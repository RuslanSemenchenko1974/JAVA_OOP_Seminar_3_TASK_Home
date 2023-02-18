package RoundHole;

/**
 * RoundHoleTask
 */
public class RoundHoleTask {

    public static void main(String[] args) {

    RoundPeg a = new SimpleRoundPeg(10);
    RoundHole b = RoundHoleMachin.createHole(a);
    System.out.println(b.getRadius());

    SquarePeg c = new SimpleSquarePeg(5);
    RoundHole d = RoundHoleMachin.createHole(new AdapterSquarePeg(c));
    System.out.println(d.getRadius());
    
    }

        public static class RoundHoleMachin {
            public static RoundHole createHole (RoundPeg peg){

                return new defaultRoundHole(peg.getRadius());
            }
        }
    public static class  defaultRoundHole implements RoundHole{
        private final double radius;
        public defaultRoundHole(double radius){
            this.radius = radius;
        }
        @Override
        public double getRadius() {
            
            return radius;
        }

    }


    public interface RoundPeg {
        double getRadius();
    }
    public interface RoundHole {
        double getRadius();
    }
    public interface SquarePeg{
        double side();
    }
    

    public  static class SimpleRoundPeg implements RoundPeg{
        private final double radius;
        public SimpleRoundPeg(double radius){
            this.radius = radius;
        }
        
        public double getRadius(){
            return radius;
        };
    }
  

    public  static class SimpleSquarePeg implements SquarePeg{
        private final double side;
        public  SimpleSquarePeg (double side){
            this.side = side;
        }
        @Override
        public double side() {
            
            return side;
        }
        
    }

    public static class AdapterSquarePeg implements RoundPeg{
        private final SquarePeg squarePeg;
        public  AdapterSquarePeg(SquarePeg squarePeg){
            this.squarePeg = squarePeg;
        }
        @Override
        public double getRadius() {
            return squarePeg.side()*Math.sqrt(2)/2;
        }

    }
}
