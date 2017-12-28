package cn.temple.orange;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 阻塞队列与非阻塞队列
 * @author Temple
 *
 */
public class DemoBlockQueue {
	@Test
	public void testProduce(){
		//需要指定最大能够保存的元素个数
		BlockingQueue<Integer>que=new ArrayBlockingQueue<Integer>(15);
		for(int i=1;i<=15;i++){
			que.add(i);
		}
//		boolean result=que.add(16);//队列满了抛出异常queue full
//		boolean result=que.offer(16);//队列满了不抛出异常
//		try {
//			que.put(16);//满了队列会阻塞，直到有空闲位置为止
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		try {
			boolean result=que.offer(16,3,TimeUnit.SECONDS);
     		System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//队列满了阻塞指定时间
	}
	@Test
	public void testConsumer(){
		BlockingQueue<Integer>que=new ArrayBlockingQueue<Integer>(15);
		que.add(2);
//		Integer result=que.remove();//取走最先添加的元素，没有就抛出异常
		Integer result=que.poll();
//		boolean result=que.remove(new Integer(1));//删除指定元素
		
		System.out.println(result);
		
	}
}
