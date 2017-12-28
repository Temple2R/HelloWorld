package cn.temple.orange;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 * FileChannel:文件通道
 * @author Temple
 *
 */
public class DemoFileChannel {
	/**
	 * 该通道不能独自存在，需要建立在FileInputStream或FileOutputStream
	 * 在输入流上得到文件通道只能执行读操作，若执行写操作，
	 * 则抛出NonWritableChannelWxception
	 * 在输出流上得到的文件通道只能执行写操作，若执行读操作，
	 * 则抛出NonReadtableChannelWxception
	 * @throws Exception
	 */
	@Test
	public void testFc() throws Exception{
		//创建输入流
		FileInputStream in =new FileInputStream(new File("1.txt"));
		//获取输出流上的文件通道
		FileChannel fc=in.getChannel();
		//下表为4开始读取
		fc.position(4);
		//创建缓冲区对象
		//读取8个字节内容
		ByteBuffer buf=ByteBuffer.allocate(8);
		//保存到buf中
		fc.read(buf);
		//输出读取到的内容
		System.out.println(new String(buf.array()));
		//设置从哪个位置开始写入
		FileOutputStream out=new FileOutputStream(new File("1.txt"));
		//执行写入操作
		fc=out.getChannel();
		fc.position(12);
		fc.write(ByteBuffer.wrap("hello".getBytes()));
		//关闭文件通道
		fc.close();
		//关闭输出流
		in.close();
		out.close();
	}
}
