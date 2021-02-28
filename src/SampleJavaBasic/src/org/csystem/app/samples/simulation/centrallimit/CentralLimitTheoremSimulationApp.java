package org.csystem.app.samples.simulation.centrallimit;

import org.csystem.util.ArrayUtil;

public class CentralLimitTheoremSimulationApp {
    private CentralLimitTheoremSimulationApp()
    {
    }

    public static void run()
    {
        CentralLimitTheoremSimulation clt = new CentralLimitTheoremSimulation(10000, 5, 1_000_000, 10);

        clt.run();
        ArrayUtil.display(clt.getCounts());
        clt.displayHistogram(50, 'X');
    }
}
