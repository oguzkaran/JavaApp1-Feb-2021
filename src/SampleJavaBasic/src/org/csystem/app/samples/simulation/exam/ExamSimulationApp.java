package org.csystem.app.samples.simulation.exam;

public class ExamSimulationApp {
    private ExamSimulationApp()
    {
    }

    public static void run()
    {
        ExamSimulation physicSimulation = new ExamSimulation("Fizik");
        ExamSimulation mathSimulation = new ExamSimulation("Matematik");

        physicSimulation.run();
        mathSimulation.run();
        physicSimulation.displayResults();
        System.out.println("//////////////////////////////////////////////////////////");
        mathSimulation.displayResults();
    }
}
