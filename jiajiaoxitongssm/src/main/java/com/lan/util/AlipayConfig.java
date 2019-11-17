package com.lan.util;
import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
/*	
密钥工具
生成密钥
签名
同步验签
异步验签
格式转换
密钥匹配
开放社区
设置*/

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101700708645";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCpSsH3krjLqO1JoJzVmOlMF8I6JesEhMF26whwgGlm1YZOnoH0MTZCOmC6RiEQl5QhZgA5bhEqCmtMcCCJZrFX8/vKLKKIF5ExcIBAP3NIUwkGGwv2M5LjhzjZKnpjBw7QG2t7K/jGs3nrhsZCRzefzc+hf5IZxjx+kedcmo9W8B125OnfX96vYxmKoLarrsvicVklJqkRt9Whd91OQk2gmczjymJdG/tBm2Ctcqg37DGUegGbvbWn/5uEMIwUESOMkhb+y5Pj7Xi5iWPuTl+jsU3s7X1pDmddzywxCRdxw9m1ORZ40xCc3v9gvvm6Aqof4HSmgDw4NJ53DDSKqLWHAgMBAAECggEBAKJX5WBD3GC5UyvbEOsoYvksg359pD1GDby7MPGpwunxc4VrLZX9p1mlX+Lho42kvlG03hw0t9MIANNhZ2I8D28XsuqzGP3HE95EU0jJUAUYU7v+Ld9gn8j/gH2I5aqXNxZMZSrOBRiPPiilqvQeFXJyzFzD2FhNKO/7fNHqCfFEZqmk0HilgeB7CERaIMN1/7/pWmB/luD/0bQ57ogySwQJm+1v8ZRLz8ga530rEROFjbsaTDAyep/rhvYr4SXPkTFCKcicAIByfmpSQrVOeMrlADo7D4U1i5DySpiLm/NJU8NVTcVF8ddz8PwybD/SrH3dWy+ani0RjmIavUV3T4kCgYEA9+7PFRUZRtLNgHwDaJz2vFDFBEuHO0YIEcPOCqc9x+CgWgj7UvYjlDZlJf31BkC8onYptW5liKadd9t27N9ZMrh3DYHTYl7CjsmNoLH+SYvU7IFdrizpVziqaiiBV4fVJWSj/+owibGLufGXPDRca6WysjxvkZptwc1TOxnNkfMCgYEArszmKwagiiBSMD9RfZh3LM3YRAs9pVBAha1lLuj0SgZLdlqDl64vB8WQ/nn9GJWOcHrVE5Vldbe/h79YYXmc4qM4L5/F/AS98oAdA3h2udy1QElLlug2YUO5GrUeZc+a4tivpF+vqtQds0r2KEKRt4xb3782PHcSlZeJ2Q1yXx0CgYBxg/+AUZavHJlGeIE/Bo7ZjcmGu+YAt4G+UH4n1oas2yXP00jupQ+JLpaFHI9w+3bik2NpVFBcjpyOYgdDUMeQN3Ea2BQmd+hwY8vahWQ93C3y0xBHTPzRGHq9/CmsH97xLfEAnQL4KDgnPHvX7slZ6BW3EYCrk58pGo8/AgNjDQKBgBHfd4VctxuIdH7kaoOqDD1zirJiZ9o4W3CPqzHhteC/xgWC+cOPltV3mPy8ImnaGOddV94Zv3cK47WQlgvZcHYn9D3CW28KWRWrjcvmDFWywIGjPOxgL/dAAnQ9oq8MTCz3tPXcpsyTxbmoZ4T0UYvv+RDmrzf9gNP0265q1o/tAoGBAJyoKuqYvGZPBpFgKHqOgz7m/CyqErMQ5tn3L7NyxHFVWSQ1G1vqUE4aMu1GsgxLriOBC6Ol/yOQVqOpV4gso+ftb6Q8oA+IYIFzEltAN1Q8LzLizP6+0SPhKj0AloPV8bOKfiSioCSpoRiHhlPlOLxOuB+OCTs1oTI85kUBdclh";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzSjlpRIzZRsfVzgXba7yWW/spBv0h4FFlyQk4ANRRmti/PMErj8fwaJk8rD9Pq+BwLGaRgJrm6dWu43HQdZImSJZGualraLzyFUuB+KE4XWKzkOZvAoNr5866MbHHhTkOdX5CYc9NjWc8Rpu6AAK8nWa8zXOwQmhz2IHZu/AriJ0dj2WkmPy+/X6AiuIm2f+b5bu+lUyZeYNPhzByOsxdFdKk6EAolQ4K6Xgx5jyCt1D/NKZ0Q6G2rTgP2ifttbaNcVhQHuTVZqIbfsWRhjIaMPfjTl/nR4XwmR/wRh+5DRyKKqEaJ9OGjB+F/fAGR9+IJwYnxP2KmwRKgSqq4E5QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:1111/AlipayJSP/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:1111/AlipayJSP/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

