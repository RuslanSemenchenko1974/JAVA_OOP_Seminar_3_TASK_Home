package RoundHole;

public class RoundHoleTask2 {

    public static void main(String[] args) {

    RoundPeg a = new SimpleRoundPeg(10);
    RoundHole b = RoundHoleMachin.createHole(a);
    System.out.println(b.getRadius());

    SquarePeg c = new SquarePeg(5);
    RoundHole d = RoundHoleMachin.createHole(c);
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

    
    public static class SquarePeg implements RoundPeg {
        private final double side;
        public  SquarePeg (double side){
            this.side = side;
        }
        public double side(){
            return side;
        }
        @Override
        public double getRadius() {
            return side*Math.sqrt(2)/2;
        }
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
    }

    

