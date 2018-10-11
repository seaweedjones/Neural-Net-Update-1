/**
 * Zain Thaver
 * Idk when I started this project
 * Makes a somewhat functional neural network
 */ 
import java.util.Random;
// note to self fix for loop spaghetti code and make neural network an object(for more customizability)
//note to self 
public class NeuralNetwork {
  public static double[][] networkData = new double [4][2];
  public static double[][] weights = new double[8][2];
  
  public static double [] lastLayer = new double[8];
  public static int  j =0;
  
  public static double sigD(double input){
    double ex=Math.pow(Math.E,input);
    return ex/((ex+1)*(ex+1));
  }
  public static double error(double ans){
    double x=0;
    double error=0;
    
    error=networkData[3][0]-ans;
    x+=error*error;
    
    return x;
  }
  /* Notes from the three brown one blue video
   // Neural Network gives a trash output
   // Cost function is the addition of the squars of the differences doing this for all training examples and averaging the results gives you the total cost
   // We need the negative slope of said cost function which tells us how to change the weights and biases to minimize error
   //magnitude of cost tells us how sensitive the cost is to each weight and bias change to larger weight = larger change in output
   // changing the larger weights has a larger influence on the cost function
   // adding toether all the nudges, processs is recursive1ly allplied
   // divide data into small, random minibatches to get the approximate gradient of cost funtion
   // We want to find out how sensitive the cost function is to each weight and bias
   // We want to find the derivative of the cost with respect to weight 
   // Find the derivative of the previous layer activation with respect to the weight
   note to self copy notes to somewhere else
     cost function = (a(L)- Y)^2
     z(L) =  w(L) * a(L-1)
     a(L) = sig(z(L))
     D C0/WL = D Z(L)/W(L)*   Da(L)/ z(L) * D C0/A(L)
      D C0/a(L) = 2(a(l)-y)
      Da(L) /z(L) = 
      D z(L)/ w(L) = a(l-1)
     note to self copy notes to somewhere else
   
   */
  public static double perecentError(double[][] weights,double [][] networkData,double answer,int numExamples)
  {
   double error =0.0;
   if( networkData[3][0] == answer)
   {
     error = error++;
   }
   return ((error/numExamples) *100.0); 
  }
  public static double backPropagate ( double [][]weights,double [][] networkData,int weightX,int weightY)
  {
    double derivative =0.0;
    double []partials = new double [3];
    partials[0] = 2 *(Math.sqrt(9));
    // do later boiii partial [1] =  
   // do it later boiiii parital [2] = 
     derivative = partials[0] * partials[1] * partials[2];
    return derivative;
    
    
    
  }
  /*@input the array for the weights to be put in 
   * @output: random weights
   * 
   */
  public static double[][] assignWeights(double [][] weights)
  {
    Random rand = new Random();
    for(int x=0;x<8;x++)
    {
      for(int y=0;y<2;y++)
      {
        double  n = ((rand.nextInt(10) + 1)/10.0);
        weights[x][y]=n;
      }
      
      
    }
    return weights;
  }
  /* Feeds the information through said network
   * 
   */
  public static double[][] feedForward(double input1,double input2,double[] lastLayer, double[][] networkData,int j)
  {
    int h=0;
    double output = 1.0;
    networkData [0][0] = 1;
    networkData [0][1] = 0;
    
    
    // assign (and multiply) all the weights for each connection
    
    
    
    for(int p=0;p<2;p++)
    {
      
      lastLayer[0] += (weights[j][p] * networkData[j][p]);
      
      
      
    }
    for(int p=0;p<2;p++)
    {
      
      lastLayer[1] += (weights[j+1][p] * networkData[j][p]);
      
      
      
    } 
    
    networkData [1][0] =sigmoid(lastLayer[0]);
    networkData [1][1] =sigmoid(lastLayer[1]);
    for(int p=0;p<2;p++)
    {
      
      lastLayer[2] += (weights[j+2][p] * networkData[j+1][p]);
      
      
    }
    for(int p=0;p<2;p++)
    {
      
      lastLayer[3] += (weights[j+3][p] * networkData[j+1][p]);
      
      
    }
    networkData [2][0] = sigmoid(lastLayer[2]);
    networkData [2][1] = sigmoid(lastLayer[3]);
    for(int p=0;p<2;p++)
    {
      
      lastLayer[4] += (weights[j+4][p] * networkData[j+2][p]);
      
      
    }
    
    networkData [3][0] = sigmoid(lastLayer[4]);
    
    
    
    //sigmoid that 
    
    //pass it off to the next layer
    j++;
    
    return networkData;
    
  }
  
  public static double sigmoid(double input)
  {
    return Math.abs(1.0/(1+(Math.pow(Math.E,-input)))); 
    
  }
  public double relu (double input)
  {
    if(input >0)
    {
      return 0;
    }
    else
    {
      return input; 
    }
  }
  
  public static void main(String[] args) { 
    
    assignWeights(weights);
    
    
    
    // calling the feed forward method
    
    double input1 =  networkData [0][0] ;
    double input2 =  networkData [0][1] ;
    feedForward( input1, input2, lastLayer,  networkData, j);
    
    System.out.print( networkData[0][0] + "-" +networkData[1][0] + "-" +networkData[2][0] + "-" +networkData[3][0] ); 
    System.out.println("");
    System.out.print( networkData[0][1] + "-" +networkData[1][1] + "-" +networkData[2][1] );
    System.out.println("");
    System.out.println("The error in the cost" + error(1.0));
    System.out.println("The percent accuracy is" + perecentError( weights, networkData,1.0,1));
    
    /* Notes from the three brown one blue video
     // Neural Network gives a trash output
     // Cost function is the addition of the squars of the differences doing this for all training examples and averaging the results gives you the total cost
     // We need the negative slope of said cost function which tells us how to change the weights and biases to minimize error
     //magnitude of cost tells us how sensitive the cost is to each weight and bias change to larger weight = larger change in output
     // changing the larger weights has a larger influence on the cost function
     // adding toether all the nudges, processs is recursive1ly allplied
     // divide data into small, random minibatches to get the approximate gradient of cost funtion
     // We want to find out how sensitive the cost function is to each weight and bias
     // We want to find the derivative of the cost with respect to weight 
     // Find the derivative of the previous layer activation with respect to the weight
     cost function = (a(L)- Y)^2
     z(L) =  w(L) * a(L-1)
     a(L) = sig(z(L))
     D C0/WL = D Z(L)/W(L)*   Da(L)/ z(L) * D C0/A(L)
      D C0/a(L) = 2(a(l)-y)
      
      D z(L)/ w(L) = a(l-1)
     note to self copy notes to somewhere else
     
     
     */
    
    
  }
  /* ADD YOUR CODE HERE */
  
}
