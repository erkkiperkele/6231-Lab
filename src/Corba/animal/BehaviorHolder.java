package Corba.animal;

/**
 * Holder class for : Behavior
 * 
 * @author OpenORB Compiler
 */
final public class BehaviorHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Behavior value
     */
    public Corba.animal.Behavior value;

    /**
     * Default constructor
     */
    public BehaviorHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public BehaviorHolder(Corba.animal.Behavior initial)
    {
        value = initial;
    }

    /**
     * Read Behavior from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = BehaviorHelper.read(istream);
    }

    /**
     * Write Behavior into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        BehaviorHelper.write(ostream,value);
    }

    /**
     * Return the Behavior TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return BehaviorHelper.type();
    }

}
