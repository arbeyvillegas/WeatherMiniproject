/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\M\\workspace-android\\Course4Miniproject\\src\\course4\\miniproject\\aidl\\WeatherCall.aidl
 */
package course4.miniproject.aidl;
/**
 * Interface defining the method that the AcronymServiceSync will
 * implement to provide synchronous access to the Acronym Web service.
 */
public interface WeatherCall extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements course4.miniproject.aidl.WeatherCall
{
private static final java.lang.String DESCRIPTOR = "course4.miniproject.aidl.WeatherCall";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an course4.miniproject.aidl.WeatherCall interface,
 * generating a proxy if needed.
 */
public static course4.miniproject.aidl.WeatherCall asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof course4.miniproject.aidl.WeatherCall))) {
return ((course4.miniproject.aidl.WeatherCall)iin);
}
return new course4.miniproject.aidl.WeatherCall.Stub.Proxy(obj);
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
course4.miniproject.aidl.WeatherData _result = this.getCurrentWeather(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements course4.miniproject.aidl.WeatherCall
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
    * A two-way (blocking) call to the AcronymServiceSync that
    * retrieves information about an acronym from the Acronym Web
    * service and returns a list of AcronymData containing the results
    * from the Web service back to the AcronymActivity.
    */
@Override public course4.miniproject.aidl.WeatherData getCurrentWeather(java.lang.String nameCity) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
course4.miniproject.aidl.WeatherData _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(nameCity);
mRemote.transact(Stub.TRANSACTION_getCurrentWeather, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = course4.miniproject.aidl.WeatherData.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getCurrentWeather = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
    * A two-way (blocking) call to the AcronymServiceSync that
    * retrieves information about an acronym from the Acronym Web
    * service and returns a list of AcronymData containing the results
    * from the Web service back to the AcronymActivity.
    */
public course4.miniproject.aidl.WeatherData getCurrentWeather(java.lang.String nameCity) throws android.os.RemoteException;
}
