package app;

/**
* app/talkHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from app.idl
* dimanche 19 novembre 2017 13 h 01 CET
*/

public final class talkHolder implements org.omg.CORBA.portable.Streamable
{
  public app.talk value = null;

  public talkHolder ()
  {
  }

  public talkHolder (app.talk initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = app.talkHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    app.talkHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return app.talkHelper.type ();
  }

}