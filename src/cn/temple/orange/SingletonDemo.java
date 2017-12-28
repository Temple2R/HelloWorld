package cn.temple.orange;
/**
 * 单例模式(懒汉+饿汉)
 * 保证软件系统中此类的实例只有一份。
 * 属于创建模式的一种。
 * 应用场景：全局资源共享对象(创建资源相对耗时)
 * 1)字符串池，整数池
 * 2)工厂对象，...
 * 单例模式的实现
 * 懒汉单例：何时需要何时创建
 * 饿汉单例：类加载时创建
 * @author Temple
 *
 */
class Singleton01{
	public Singleton01() {
	}
	private static Singleton01 instance=null;
	//任何想要获得instance实例必须进入这个同步块
	public static synchronized Singleton01 getInstance(){
		if(instance==null){
			instance=new Singleton01();
		}
		return instance;
	}
}
/**优化版的懒汉单例*/
class Singleton02{
	private Singleton02() {
	}
	private static volatile Singleton02 instance=null;
	public static Singleton02 getInstance(){
		if(instance==null){
			synchronized (Singleton02.class) {
				if(instance==null){
					instance=new Singleton02();
				}
			}
		}
		return instance;
	}

}
/**饿汉单例*/
class Singleton03{
	private Singleton03() {
	}
	private static Singleton03 instance=new Singleton03();
	public static Singleton03 getInstance(){
		return instance;
	}
}
/**饿汉单例优化版(延迟对象的初始化)：何时需要何时创建，加个内部类*/
class Singleton04{
	private Singleton04() {
	}
	private static class LazyInner{
		public static Singleton04 instance=new Singleton04();
	}
	public static Singleton04 getInstance(){
		return LazyInner.instance;
	}
}
public class SingletonDemo {
}
