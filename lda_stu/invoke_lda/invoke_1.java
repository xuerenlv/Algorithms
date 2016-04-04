package invoke_lda;

import jgibblda.Estimator;
import jgibblda.Inferencer;
import jgibblda.LDACmdOption;
import jgibblda.Model;

public class invoke_1 {

	public static void main(String[] args) {

		LDACmdOption option = new LDACmdOption();

		// -est -alpha 0.2 -beta 0.1 -ntopics 100 -niters 1000 -savestep 100
		// -twords 100 -dir
		// C:\Users\x\MyEclipse1\JGibbLDA-v.1.0\models\casestudy-en -dfile
		// "newdocs.dat"
		option.alpha = 0.2;
		option.beta = 0.1;
		option.K = 15;
		option.niters = 500;
		option.savestep = 500;
		option.twords = 20;
		option.modelName = "xhj_model_final";
		option.dir = "./file/casestudy-en/";
		option.dfile = "newdocs.dat";
		option.est = true;
		
		Estimator estimator = new Estimator();
		estimator.init(option);
		estimator.estimate();
		
		

		if (option.est || option.estc) {
//			Estimator estimator = new Estimator();
//			estimator.init(option);
//			estimator.estimate();
		} else if (option.inf) {
//			Inferencer inferencer = new Inferencer();
//			inferencer.init(option);
//
//			Model newModel = inferencer.inference();
//
//			for (int i = 0; i < newModel.phi.length; ++i) {
//				System.out.println("-----------------------\ntopic" + i + " : ");
//				for (int j = 0; j < 10; ++j) {
//					System.out.println(inferencer.globalDict.id2word.get(j) + "\t" + newModel.phi[i][j]);
//				}
//			}
		}
	}

}
