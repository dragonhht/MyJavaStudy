package com.github.dragonhht;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import principle.MyProxy;
import java.lang.reflect.UndeclaredThrowableException;
public final class $Proxy1 extends MyProxy implements simple.UserService {
private static Method m0;
private static Method m1;
private static Method m2;
private static Method m3;
public $Proxy1(MyInvocationHandler h) {
super(h);
}
public final java.lang.String getName(int var0 ) {
try {
return (java.lang.String)super.h.invoke(this, m0, new Object[]{var0 });} catch (RuntimeException | Error var1) {
throw var1;
} catch (Throwable var2) {
throw new UndeclaredThrowableException(var2);
}
}
public final java.lang.String getRoom(int var0 ) {
try {
return (java.lang.String)super.h.invoke(this, m1, new Object[]{var0 });} catch (RuntimeException | Error var1) {
throw var1;
} catch (Throwable var2) {
throw new UndeclaredThrowableException(var2);
}
}
public final void noReturnAndParam() {
try {
super.h.invoke(this, m2, (Object[])null} catch (RuntimeException | Error var0) {
throw var0;
} catch (Throwable var1) {
throw new UndeclaredThrowableException(var1);
}
}
public final int getAge(int var0 ) {
try {
return (int)super.h.invoke(this, m3, new Object[]{var0 });} catch (RuntimeException | Error var1) {
throw var1;
} catch (Throwable var2) {
throw new UndeclaredThrowableException(var2);
}
}
static {
try {
m0 = Class.forName("simple.UserService").getMethod("getName", int.class );
m1 = Class.forName("simple.UserService").getMethod("getRoom", int.class );
m2 = Class.forName("simple.UserService").getMethod("noReturnAndParam");
m3 = Class.forName("simple.UserService").getMethod("getAge", int.class );
} catch (NoSuchMethodException var2) {
throw new NoSuchMethodError(var2.getMessage());
} catch (ClassNotFoundException var3) {
throw new NoClassDefFoundError(var3.getMessage());
}
}
}