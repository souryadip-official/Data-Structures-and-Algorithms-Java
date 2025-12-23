import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Job {
    char jobName;
    int deadline;
    int profit;
}
public class JobSequencingProblem {
    public static void merge(ArrayList<Job> jobs, int low, int mid, int high) {
        ArrayList<Job> newJobs = new ArrayList<>();
        int i = low, j = mid+1;
        while(i <= mid && j <= high) {
            if(jobs.get(i).profit > jobs.get(j).profit)
                newJobs.add(jobs.get(i++));
            else
                newJobs.add(jobs.get(j++));
        }
        while(i <= mid) newJobs.add(jobs.get(i++));
        while(j <= high) newJobs.add(jobs.get(j++));
        for(int k=0; k<newJobs.size(); k++)
            jobs.set(k+low, newJobs.get(k));
    }
    public static void mergeSort(ArrayList<Job> jobs, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(jobs, low, mid);
            mergeSort(jobs, mid+1, high);
            merge(jobs, low, mid, high);
        }
    }
    public static int getMaximumDeadline(ArrayList<Job> jobs) {
        int maxDeadline = Integer.MIN_VALUE;
        for(int i=0; i<jobs.size(); i++)
            maxDeadline = Math.max(maxDeadline, jobs.get(i).deadline);
        return maxDeadline;
    }
    public static void maxJobs(ArrayList<Job> jobs) {
        mergeSort(jobs, 0, jobs.size()-1);
        /* Or we may write, Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); */
        ArrayList<String> result = new ArrayList<>();
        int maxDeadline = getMaximumDeadline(jobs);
        boolean[] slots = new boolean[maxDeadline+1]; /* [0...maxDeadline] */
        int jobsCompleted = 0;
        int maxProfit = 0;
        for(int i=0; i<jobs.size(); i++) {
            int currJobDeadline = jobs.get(i).deadline;
            for(int deadline = currJobDeadline; deadline >= 1; deadline--) {
                /* Alloting deadline for this particular job to the maximum deadline possible, so that I can accommodate more jobs if present before it */
                if(slots[deadline] == false) {
                    /* this means that this slot is empty */
                    jobsCompleted++;
                    result.add("Job " + jobs.get(i).jobName);
                    maxProfit += jobs.get(i).profit;
                    slots[deadline] = true;
                    break; /* We have found a free slot for this job */
                    /* This is because every job takes exactly a single unit of time for completion. So, everytime we complete a job, we increase the currTime by 1 */
                }
            }
        }
        System.out.println("Maximum jobs completed: " + jobsCompleted);
        System.out.println("The jobs are: " + result);
        System.out.println("Maximum profit earned: " + maxProfit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<n; i++) {
            Job job = new Job();
            job.jobName = (char) (i + 65);
            System.out.print("Enter deadline and profit for job " + i + ": ");
            job.deadline = sc.nextInt();
            job.profit = sc.nextInt();
            jobs.add(job);
        }
        maxJobs(jobs);
        sc.close();
    }
}
