# RMI学习

##   实现一个rmi示例

-   编写远程接口

    ```java
    public interface HelloService extends Remote {
    
        String hello(String name) throws RemoteException;
    
    }
    ```
    
    -   说明:
    
        -   接口继承`java.rmi.Remote`接口

        
-   实现编写的远程接口

    ```java
    public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    
        protected HelloServiceImpl() throws RemoteException {
            
        }
    
        public String hello(String name) throws RemoteException {
            return "hello " + name;
        }
    }
    ```
    
    -   说明:
    
        -   类实现编写的远程调用接口
        
        -   类继承`java.rmi.server.UnicastRemoteObject`
        
        
-   发布服务

    ```java
    public class Service {
    
        public static void main(String[] args) {
            try {
                // 实例化服务对象
                HelloService service = new HelloServiceImpl();
                // 注册远程调用对象
                LocateRegistry.createRegistry(9999);
                Naming.bind("rmi://localhost:9999/hello", service);
    
                System.out.println("发布成功...");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    }
    ```
    
    -   说明:
    
        -   首先实例化一个服务对象
        
        -   使用`LocateRegistry.createRegistry`方法绑定端口
        
        -   使用`Naming.bind;`方法将服务对象绑定到指定的url上
        
-   客户端调用

    ```java
    public class Client {
    
        public static void main(String[] args) {
            try {
                // 获取服务对象
                HelloService service = (HelloService) Naming.lookup("rmi://localhost:9999/hello");
                // 调用服务接口
                System.out.println(service.hello("dragonhht"));
    
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    
    }
    ```
    
    -   说明:
    
        -   使用`Naming.lookup`方法，参入服务端服务对象绑定的url地址获取到服务对象
        
        -   通过服务对象调用接口
