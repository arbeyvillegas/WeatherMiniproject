/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\SGYC\\Desarrollo\\GitHub\\Android\\WeatherMiniproject\\src\\course4\\miniproject\\aidl\\WeatherResults.aidl
 */
package course4.miniproject.aidl;
/**
 * Interface defining the method that receives callbacks from the
 * AcronymServiceAsync.
 */
public interface WeatherResults extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements course4.miniproject.aidl.WeatherResults
{
private static final java.lang.String DESCRIPTOR = "course4.miniproject.aidl.WeatherResults";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an course4.miniproject.aidl.WeatherResults interface,
 * generating a proxy if needed.
 */
public static course4.miniproject.aidl.WeatherResults asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof course4.miniproject.aidl.WeatherResults))) {
return ((course4.miniproject.aidl.WeatherResults)iin);
}
return new course4.miniproject.aidl.WeatherResults.Stub.Proxy(obj);
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
case TRANSACTION_sendResult:
{
data.enforceInterface(DESCRIPTOR);
course4.miniproject.aidl.WeatherData _arg0;
if ((0!=data.readInt())) {
_arg0 = course4.miniproject.aidl.WeatherData.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.sendResult(_arg0);
return true;
}
case TRANSACTION_sendError:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.sendError(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements course4.miniproject.aidl.WeatherResults
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
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return the List of WeatherData results associated with a
     * one-way AcronymRequest.callAcronymRequest() call.
     */
@Override public void sendResult(course4.miniproject.aidl.WeatherData result) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((result!=null)) {
_data.writeInt(1);
result.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendResult, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return an error String if the Service fails for some reason.
     */
@Override public void sendError(java.lang.String reason) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(reason);
mRemote.transact(Stub.TRANSACTION_sendError, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_sendResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_sendError = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return the List of WeatherData results associated with a
     * one-way AcronymRequest.callAcronymRequest() call.
     */
public void sendResult(course4.miniproject.aidl.WeatherData result) throws android.os.RemoteException;
/**
     * This one-way (non-blocking) method allows WeatherServiceAsync
     * to return an error String if the Service fails for some reason.
     */
public void sendError(java.lang.String reason) throws android.os.RemoteException;
}
