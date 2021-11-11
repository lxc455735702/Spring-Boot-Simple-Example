# Hutool webService 

## 1.1 webServiceSoap

很多情况下我们会遇到webService的接口，有些比较简单的接口想轻量级的库。

看到hutool有关于soap的相关资料，准备试试 还是遇到不少问题的

[hutool关于SoapClient的文档](https://www.bookstack.cn/read/hutool/76c5345e79ccc22b.md)

按着相关文档接入遇到两个问题如下

### 1.1.1 java.lang.NoClassDefFoundError : javax/xml/soap/SOAPException

描述：一开始测试的时候遇到 java.lang.NoClassDefFoundError : javax/xml/soap/SOAPException

了解：我本地用的是JDK11,可能是JDK8之后有一些相关的类被删除了

解决方案：

```java
<dependency>
   <groupId>javax.xml.soap</groupId>
   <artifactId>javax.xml.soap-api</artifactId>
   <version>1.4.0</version>
</dependency>
```

查阅资料：

- https://github.com/dromara/hutool/issues/779
- https://stackoverflow.com/questions/48626824/java-lang-noclassdeffounderror-javax-xml-soap-soapexception  

### 1.1.2 com.sun.xml.internal.messaging.saaj.soap.SAAJMetaFactoryImpl not found

描述：1.1.1的问题解决之后 就出现这样的错误提示

解决方案：

```java
<dependency>
  <groupId>com.sun.xml.messaging.saaj</groupId>
  <artifactId>saaj-impl</artifactId>
  <version>1.5.1</version>
</dependency>
```

查阅资料：

https://stackoverflow.com/questions/47887047/java-com-sun-xml-internal-messaging-saaj-soap-saajmetafactoryimpl-not-found