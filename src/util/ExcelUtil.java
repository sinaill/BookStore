package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	public static void createExcel(List<? extends Object> objects,String path) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//获取目标类参数列表和方法列表
		List<String> fieldList = new ArrayList<String>();
		List<Method> methodList = new ArrayList<Method>();
		Class<? extends Object> c = objects.get(0).getClass();
		Field [] fields =  c.getDeclaredFields();
		String str = "";
		for(Field field:fields){
			str = field.getName();
			fieldList.add(str);//参数名称放入list中
			str = "get"+str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
			Method method;
			try {
				method = c.getDeclaredMethod(str);
				methodList.add(method);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		//创建表头
		HSSFWorkbook hw = new HSSFWorkbook();
		HSSFSheet sheet = hw.createSheet("表一");
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle style = hw.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell cell = null;
		for(int i = 0;i < fieldList.size(); i++){
			cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(fieldList.get(i));
		}
		//便利list添加数据
		String dateValue;
		String strValue;

		int intValue;
		for(int i = 0;i < objects.size();i++){
			row = sheet.createRow(i+1);
			for(int j = 0;j < methodList.size();j++){
				cell = row.createCell(j);
				cell.setCellStyle(style);
				switch (methodList.get(j).getReturnType().getName()) {
				case "java.util.Date":
					Date date = (Date) methodList.get(j).invoke(objects.get(i));
					dateValue = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
					cell.setCellValue(dateValue);
					break;
				case "java.lang.String":
					strValue = (String) methodList.get(j).invoke(objects.get(i));
					cell.setCellValue(strValue);
					break;
				case "java.lang.Integer":
					intValue = (int) methodList.get(j).invoke(objects.get(i));
					cell.setCellValue(intValue);
					break;
				default:
					int temp = (int) methodList.get(j).invoke(objects.get(i));
					
					cell.setCellValue((double)temp);

					break;
				}
				
				
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			hw.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
}
}