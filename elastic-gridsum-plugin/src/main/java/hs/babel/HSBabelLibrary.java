package hs.babel;

public class HSBabelLibrary {
	static

    {
          System.load("/opt/cassandra/elasticsearch-6.3.2/data/openbabel/lib/libobabel2_java.so");
//        System.load("/home/zhangxin/data/openbabel-2.4.1/JAVA/libobabel2_java.so");

    } 
	// generate hs_yzm_HSLibrary.h in /home/h/workspace-java/yzm/webroot/WEB-INF/classes/  
    // using /usr/local/share/jdk1.8.0_91/bin/javah
	public native static long    initConv ();
	public native static String  ConvFullConvert (long Conv_in, String str );
	public native static String  GetOBFingerprint (long Conv_in, String fptvec_str );
	public native static float   GetSimilarity(String fptvec_str1, String fptvec_str2);	
}
