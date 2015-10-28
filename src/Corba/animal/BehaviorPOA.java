package Corba.animal;

/**
 * Interface definition: Behavior.
 * 
 * @author OpenORB Compiler
 */
public abstract class BehaviorPOA extends org.omg.PortableServer.Servant
        implements BehaviorOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Behavior _this()
    {
        return BehaviorHelper.narrow(_this_object());
    }

    public Behavior _this(org.omg.CORBA.ORB orb)
    {
        return BehaviorHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:animal/Behavior:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("eat")) {
                return _invoke_eat(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_eat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        eat();

        _output = handler.createReply();

        return _output;
    }

}
