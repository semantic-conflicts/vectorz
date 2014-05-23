package mikera.matrixx.decompose.qr.impl;

import mikera.matrixx.Matrix;
import mikera.matrixx.decompose.IQRResult;
import mikera.matrixx.decompose.impl.qr.HouseholderQR;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHouseholderQR {

  @Test
  public void testDecompose() {
    double[][] dataA = {{0, 3, 1}, {0, 4, -2}, {2, 1, 1}};
    Matrix A = Matrix.create(dataA);
    IQRResult alg = new HouseholderQR(A, false);
    Matrix Q = alg.getQ();
    Matrix R = alg.getR();

    double[][] exceptDataQ = {{0, -0.6, 0.8}, {0, -0.8, -0.6}, {-1, 0, 0}};
    double[][] exceptDataR = {{-2, -1, -1}, {0, -5, 1}, {0, 0, 2}};
    Matrix exceptQ = Matrix.create(exceptDataQ);
    Matrix exceptR = Matrix.create(exceptDataR);
    assertEquals(Q, exceptQ);
    assertEquals(R, exceptR);

    A = Matrix.create(dataA);
    alg = new HouseholderQR(A, true);
    Q = alg.getQ();
    R = alg.getR();

    assertEquals(Q, exceptQ);
    assertEquals(R, exceptR);
  }
}
