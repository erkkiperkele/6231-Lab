package Corba.animal;

/** 
 * Helper class for : Behavior
 *  
 * @author OpenORB Compiler
 */ 
public class BehaviorHelper
{
    /**
     * Insert Behavior into an any
     * @param a an any
     * @param t Behavior value
     */
    public static void insert(org.omg.CORBA.Any a, Corba.animal.Behavior t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract Behavior from an any
     *
     * @param a an any
     * @return the extracted Behavior value
     */
    public static Corba.animal.Behavior extract( org.omg.CORBA.Any a )
    {
        if ( !a.type().equivalent( type() ) )
        {
            throw new org.omg.CORBA.MARSHAL();
        }
        try
        {
            return Corba.animal.BehaviorHelper.narrow( a.extract_Object() );
        }
        catch ( final org.omg.CORBA.BAD_PARAM e )
        {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Behavior TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc( id(), "Behavior" );
        }
        return _tc;
    }

    /**
     * Return the Behavior IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:animal/Behavior:1.0";

    /**
     * Read Behavior from a marshalled stream
     * @param istream the input stream
     * @return the readed Behavior value
     */
    public static Corba.animal.Behavior read(org.omg.CORBA.portable.InputStream istream)
    {
        return(Corba.animal.Behavior)istream.read_Object(Corba.animal._BehaviorStub.class);
    }

    /**
     * Write Behavior into a marshalled stream
     * @param ostream the output stream
     * @param value Behavior value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, Corba.animal.Behavior value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to Behavior
     * @param obj the CORBA Object
     * @return Behavior Object
     */
    public static Behavior narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Behavior)
            return (Behavior)obj;

        if (obj._is_a(id()))
        {
            _BehaviorStub stub = new _BehaviorStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to Behavior
     * @param obj the CORBA Object
     * @return Behavior Object
     */
    public static Behavior unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof Behavior)
            return (Behavior)obj;

        _BehaviorStub stub = new _BehaviorStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
