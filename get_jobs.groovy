def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name == jobPattern
    }
    
// using regexp
def matchedJobs = Jenkins.instance.items.findAll { job ->
        job.name =~ /$jobPattern/
    }
