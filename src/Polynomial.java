
public class Polynomial {
    PolyUnit polyUnit = new PolyUnit(0,0);


    public Polynomial() 
    {
        this.polyUnit = new PolyUnit(0,0);
    }

    public void addPolyUnit(int coefficient, int exponent) 
    {
        addPolyUnit(new PolyUnit(coefficient, exponent));
    }

    public void addPolyUnit(PolyUnit polyUnit) 
    {
        if (polyUnit == null)
        {
            System.out.println("polyUnit is null");
            return;
        }
        if (polyUnit.exponent == 0)
        {
            this.polyUnit.coefficient += polyUnit.coefficient;
            return;
        }
        if (polyUnit.exponent > 0)
        {
            while(true)
            {
                if (this.polyUnit.exponent == polyUnit.exponent)
                {
                    this.polyUnit.coefficient += polyUnit.coefficient;
                    break;
                }
                if (this.polyUnit.prev == null)
                {
                    addPolyUnitToFront(new PolyUnit(0, this.polyUnit.exponent + 1), this.polyUnit);
                }
                this.polyUnit = this.polyUnit.prev;
            }
        }
        if (polyUnit.exponent < 0)
        {
            while(true)
            {
                if (this.polyUnit.exponent == polyUnit.exponent)
                {
                    this.polyUnit.coefficient += polyUnit.coefficient;
                    break;
                }
                if (this.polyUnit.next == null)
                {
                    addPolyUnitToBack(this.polyUnit, new PolyUnit(0, this.polyUnit.exponent - 1));
                }
                this.polyUnit = this.polyUnit.next;
            }
        }
        this.polyUnit = goto0(this.polyUnit);
        
    }

    private void addPolyUnitToFront(PolyUnit frontPolyUnit, PolyUnit nowPolyUnit)
    {
        if (frontPolyUnit == null)
        {
            System.out.println("polyUnit is null");
            return;
        }
        nowPolyUnit.prev = frontPolyUnit;
        frontPolyUnit.next = nowPolyUnit;
    }

    private void addPolyUnitToBack(PolyUnit nowPolyUnit, PolyUnit backPolyUnit)
    {
        if (backPolyUnit == null)
        {
            System.out.println("polyUnit is null");
            return;
        }
        nowPolyUnit.next = backPolyUnit;
        backPolyUnit.prev = nowPolyUnit;
    }

    private PolyUnit goto0(PolyUnit polyUnit)
    {
        if (polyUnit.exponent > 0)
        {
            return goto0(polyUnit.next);
        }
        else if (polyUnit.exponent < 0)
        {
            return goto0(polyUnit.prev);
        }
        else if (polyUnit.exponent == 0)
        {
            return polyUnit;
        }    
        else 
        {
            System.out.println("goto0 has an error");
            return null;
        }
    }

    private PolyUnit gotoFront(PolyUnit polyUnit)
    {
        if (polyUnit.prev == null)
        {
            return polyUnit;
        }
        else
        {
            return gotoFront(polyUnit.prev);
        }
    }

    @Override
    public String toString()
    {
        String result = "";
        PolyUnit polyUnit = gotoFront(this.polyUnit);
        while(true)
        {
            if (polyUnit.coefficient == 0);
            else if (polyUnit.exponent > 0)
            {
                result += polyUnit.coefficient + "x^" + polyUnit.exponent;
            }
            else if (polyUnit.exponent == 0)
            {
                result += polyUnit.coefficient + "";
            }
            else if (polyUnit.exponent < 0)
            {
                result += polyUnit.coefficient + "x^(" + polyUnit.exponent + ")";
            }
            else
            {
                System.out.println("toString has an error");
                break;
            }
            if (polyUnit.next == null)
            {
                break;
            }
            polyUnit = polyUnit.next;
            if (polyUnit.coefficient != 0) result += " + ";
            
        }
        return result;
    }


}
