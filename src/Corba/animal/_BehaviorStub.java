package Corba.animal;

/**
 * Interface definition: Behavior.
 * 
 * @author OpenORB Compiler
 */
public class _BehaviorStub extends org.omg.CORBA.portable.ObjectImpl
        implements Behavior
{
    static final String[] _ids_list =
    {
        "IDL:animal/Behavior:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = Corba.animal.BehaviorOperations.class;

    /**
     * Operation eat
     */
    public void eat()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("eat",true);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("eat",_opsClass);
                if (_so == null)
                   continue;
                Corba.animal.BehaviorOperations _self = (Corba.animal.BehaviorOperations) _so.servant;
                try
                {
                    _self.eat();
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
