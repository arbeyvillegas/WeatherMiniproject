/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\M\\workspace-android\\Course4Miniproject\\src\\course4\\miniproject\\aidl\\WeatherRequest.aidl
 */
package course4.miniproject.aidl;
/**
 * Interface defining the method that the AcronymServiceAsync will
 * implement to provide asynchronous access to the Acronym Web
 * service.
 */
public interface WeatherRequest extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements course4.miniproject.aidl.WeatherRequest
{
private static final java.lang.String DESCRIPTOR = "course4.miniproject.aidl.WeatherRequest";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an course4.miniproject.aidl.WeatherRequest interface,
 * generating a proxy if needed.
 */
public static course4.miniproject.aidl.WeatherRequest asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof course4.miniproject.aidl.WeatherRequest))) {
return ((course4.miniproject.aidl.WeatherRequest)iin);
}
return new course4.miniproject.aidl.WeatherRequest.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getCurrentWeather:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
course4.miniproject.aidl.WeatherResults _arg1;
_arg1 = course4.miniproject.aidl.WeatherResults.Stub.asInterface(data.readStrongBinder());
this.getCurrentWeather(_arg0, _arg1);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements course4.miniproject.aidl.WeatherRequest
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
    * A one-way (non-blocking) call to the AcronymServiceAsync that
    * retrieves information about an acronym from the Acronym Web
    * service.  The AcronymServiceAsync subsequently uses the
    * AcronymResults parameter to return a List of AcronymData
    * containing the results from the Web service back to the
    * AcronymActivity.
    */
@Override public void getCurrentWeather(java.lang.String nameCity, course4.miniproject.aidl.WeatherResults results) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(nameCity);
_data.writeStrongBinder((((results!=null))?(results.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_getCurrentWeather, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_getCurrentWeather = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
    * A one-way (non-blocking) call to the AcronymServiceAsync that
    * retrieves information about an acronym from the Acronym Web
    * service.  The AcronymServiceAsync subsequently uses the
    * AcronymResults parameter to return a List of AcronymData
    * containing the results from the Web service back to the
    * AcronymActivity.
    */
public void getCurrentWeather(java.lang.String nameCity, course4.miniproject.aidl.WeatherResults results) throws android.os.RemoteException;
}
