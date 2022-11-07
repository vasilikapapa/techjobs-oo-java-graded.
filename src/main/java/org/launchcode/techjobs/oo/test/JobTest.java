package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields()
    {
       Job job =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getEmployer() instanceof Employer );
        assertTrue(job.getPositionType() instanceof PositionType );
        assertTrue(job.getLocation() instanceof Location );
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency );
        assertTrue(job instanceof Job );

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality()
    {
        Job job1 = new Job();
        job1.setName("Product Tester");
        Job job2 = new Job();
        job2.setName("Product Tester");
        assertEquals(job1.getName(), job2.getName());
        assertFalse(job1.getId() == job2.getId());

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine()
    {
        Job job =  new Job();
        Job job1 = new Job();
        String testString = job.toString(job1);
        assertEquals('\n', testString.charAt(0));
        assertEquals('\n', testString.charAt(testString.length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData()
    {
        Job job =  new Job();
        Job job1 = new Job();
        String testString = job.toString(job1);
        String expectedString = "\nID: "+ job1.getId()+  "\n" +
                "Name: "+ job1.getName()+ "\n" +
                "Employer: "+ job1.getEmployer()+ "\n" +
                "Location: "+ job1.getLocation()+ "\n" +
                "Position Type: "+ job1.getPositionType()+ "\n" +
                "Core Competency: "+ job1.getCoreCompetency()+ "\n";
        assertEquals(expectedString, testString);


    }

    @Test

    public void testToStringHandlesEmptyField()
    {
        Job job =  new Job();
        Job job1 = new Job();

    }
}
