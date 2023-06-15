import javax.lang.model.util.ElementScanner14;

public class Polynomial {
    PolyUnit polyUnit = new PolyUnit(0,0);

    public void addPolyUnit(PolyUnit polyUnit) {
        if (this.polyUnit == null) 
        {
            this.polyUnit = polyUnit;
            return;
        }
        PolyUnit temp = this.polyUnit;
        if (temp.exponent == polyUnit.exponent) 
        {
            System.out.println("Exponent already exists");
            return;
        }
        else if (temp.exponent > polyUnit.exponent) 
        {
            if (temp.next.exponent < polyUnit.exponent)
            {
                temp = setUnitToMiddle(temp, polyUnit);
                temp = goto0(temp);
                this.polyUnit = temp;
                return;
            }
            
        }
        else if (temp.exponent < polyUnit.exponent)
        
    }

    private PolyUnit setUnitToMiddle(PolyUnit front, PolyUnit middle)
    {   
        middle.prev = front;
        middle.next = front.next;
        front.next.prev = middle;
        front.next = middle;
        return front;
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


}
