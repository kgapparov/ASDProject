package Internal.framework.dataAccess;

import Internal.framework.module.Report;

public abstract class ReportFactory {
    public void displayReport() {
        Report report = createReport();
        System.out.println(report);
    }

    public abstract Report createReport();
}
