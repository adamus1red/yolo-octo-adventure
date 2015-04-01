package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import junit.framework.TestCase;

public class ModelTests extends TestCase {
	
	Model m = new Model();
	
	// TEST TO MAKE SURE SQUARE IS ADDED AT THE CORRECT COORDINATE // 
		
		public void testSquareBumper(){
			SquareBumper sq = new SquareBumper(100,100,"test",m);
			assertEquals(sq.getXPos(),100);
			assertEquals(sq.getYPos(),100);
			assertEquals(sq.getType(),"Square");
			assertEquals(sq.getHeight(),25);
			assertEquals(sq.getWidth(),25);
		}
		
		// TEST TO MAKE SURE TRIANGLE IS ADDED AT THE CORRECT COORDINATE // 
				
				public void testTriangleBumper(){
					TriangleBumper tr = new TriangleBumper(100,100,"test",m);
					assertEquals(tr.getXPos(),100);
					assertEquals(tr.getYPos(),100);
					assertEquals(tr.getType(),"Triangle");
					assertEquals(tr.getHeight(),25);
					assertEquals(tr.getWidth(),25);
				}

			// TEST TO MAKE SURE CIRCLE IS ADDED AT THE CORRECT COORDINATES // 
				
				public void testCircleBumper(){
					CircleBumper ci = new CircleBumper(100,100,"test",m);
					assertEquals(ci.getXPos(),100);
					assertEquals(ci.getYPos(),100);
					assertEquals(ci.getType(),"Circle");
					assertEquals(ci.getRadius(),12);
					
				}
				
			// TEST TO MAKE SURE ABSORBER IS ADDED CORRECTLY //
				
				public void testAbsorber(){
					Absorber ab = new Absorber(100,100,500, 20, "test",m);
					assertEquals(ab.getXPos(),100);
					assertEquals(ab.getYPos(),100);
					assertEquals(ab.getWidth(),500);
					assertEquals(ab.getHeight(),20);
					assertEquals(ab.getType(),"Absorber");
				}
				
			// TEST TO MAKE SURE LEFT FLIPPER IS ADDED CORRECTLY // 
				
				public void testFlip(){
					Flipper fl = new Flipper(100,100,"test",m);
					assertEquals(fl.getXPos(),100);
					assertEquals(fl.getYPos(),100);
					assertEquals(fl.getType(),"Flipper");
				}
			
				
			// TEST TO MAKE SURE BALLS ARE ADDED //
				
				public void testBall(){
					Ball b = new Ball(100,100,100,100,"test");
					m.addBall(b);
					assertNotNull(m.getBalls());
					int xVel = (int) b.getVelo().x();
					assertEquals(xVel,100);
					int yVel = (int) b.getVelo().y();
					assertEquals(yVel,100);
				}


}
