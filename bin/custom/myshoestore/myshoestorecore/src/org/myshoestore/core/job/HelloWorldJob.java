package org.myshoestore.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.myshoestore.core.model.HelloWorldCronJobModel;

public class HelloWorldJob extends AbstractJobPerformable<HelloWorldCronJobModel>
{

    @Override
    public PerformResult perform(final HelloWorldCronJobModel cronJobModel)
    {
        try
        {
            // Retrieve firstName from the cronJob
            final String name = cronJobModel.getName();

            // Display Hello firstName
            System.out.println("Hello " + name);

            // In case of success return result: SUCCESS and status: FINISHED
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

        }
        catch (final Exception e)
        {

            // In case of exception return result: ERROR and status: ABORTED
            return new PerformResult(CronJobResult.ERROR, CronJobStatus.ABORTED);

        }
    }
}