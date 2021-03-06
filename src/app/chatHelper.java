package app;


/**
* app/chatHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from app.idl
* dimanche 19 novembre 2017 13 h 01 CET
*/

abstract public class chatHelper
{
  private static String  _id = "IDL:app/chat:1.0";

  public static void insert (org.omg.CORBA.Any a, app.chat that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static app.chat extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (app.chatHelper.id (), "chat");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static app.chat read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_chatStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, app.chat value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static app.chat narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof app.chat)
      return (app.chat)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      app._chatStub stub = new app._chatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static app.chat unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof app.chat)
      return (app.chat)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      app._chatStub stub = new app._chatStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
