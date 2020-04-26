package Factory;

import java.util.*;

public class Context
{
    private LinkedList<Double> calcStack = new LinkedList<Double>();
    private HashMap<String, Double> constants = new HashMap<String, Double>();

    public double getConstant(String var) throws NoSuchElementException
    {
        if (!constants.containsKey(var)) {
            throw new NoSuchElementException("Stack doesn't contain Constant of " + var);
        }
        return constants.get(var);
    }

    public void setConstant(String var, Double value)
    {
        constants.put(var, value);
    }

    public void pushToStack(double value)
    {
        calcStack.push(value);
    }

    public double popFromStack() throws EmptyStackException
    {
        return calcStack.pop();
    }

    public double peekAtStack() throws EmptyStackException
    {
        return calcStack.peek();
    }
}