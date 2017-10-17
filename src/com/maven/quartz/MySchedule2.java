package com.maven.quartz;


import java.util.List;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import entity.Product;
import redis.clients.jedis.Jedis;
import service.Productservice;
import util.RedisUtils;
import util.SerializeUtils;

public class MySchedule2 implements Job{
	@Resource(name="Productservice")
	private Productservice productservice;
	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(productservice);
	}

}
