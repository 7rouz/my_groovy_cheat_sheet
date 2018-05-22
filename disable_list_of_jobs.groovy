import jenkins.model.*;
import hudson.model.*;
import hudson.tasks.*;

// get job list from prams
def jobs_list = build.buildVariableResolver.resolve("job_list")
// split list by ;
def list_of_jobs = jobs_list.split(";")

list_of_jobs.each { job_name ->
    jobPattern = job_name.trim()
    // get job that match pattern
    def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name == jobPattern
    }
    // deactivate job
    matchedJobs.each { job ->    
     println "Disabling matching job ${job.name}"
     job.disable()
      if (job.isBuildable()) {
       println "job ${job.name} is always enabled !!"
      }
      else {
        println "job ${job.name} was successfully disabled!!"
      }
      println "-" * 80
    }
}
