import java.util.LinkedList;

class BMI4 implements IBMIProbs {
    BMI4() {
    }

    // single loop
    public BMISummary bmiReport(LinkedList<PHR> phrs) {
        LinkedList<String> under = new LinkedList<String>();
        LinkedList<String> healthy = new LinkedList<String>();
        LinkedList<String> over = new LinkedList<String>();
        LinkedList<String> obese = new LinkedList<String>();

        for (int i = 0; i < phrs.size(); i++) {

            if (BMI(phrs.get(i)) < 18.5) {
                under.add(phrs.get(i).name);
            } else if (BMI(phrs.get(i)) >= 18.5 && BMI(phrs.get(i)) < 25) {
                healthy.add(phrs.get(i).name);
            } else if (BMI(phrs.get(i)) >= 25 && BMI(phrs.get(i)) < 30) {
                over.add(phrs.get(i).name);
            } else if (BMI(phrs.get(i)) >= 30) {
                obese.add(phrs.get(i).name);
            }

        }
        return new BMISummary(under, healthy, over, obese);
    }

    double BMI(PHR phr) {
        double weight = phr.weight;
        double height = phr.height;
        return weight / (height * height);
    }
}