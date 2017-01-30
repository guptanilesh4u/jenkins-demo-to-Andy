node {

	stage 'CHECKOUT'
		echo 'Hello World'
	   	checkout([$class: 'SubversionSCM', additionalCredentials: [], excludedCommitMessages: '', excludedRegions: '', excludedRevprop: '', excludedUsers: '', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: '', locations: [[credentialsId: '3adac08b-b81c-432e-b42f-fd8313d6fcdd', depthOption: 'infinity', ignoreExternalsOption: true, local: '.', remote: 'http://ec2-35-161-144-28.us-west-2.compute.amazonaws.com/svn/repository/myfirstproject/trunk']], workspaceUpdater: [$class: 'UpdateWithRevertUpdater']])
   
    stage 'BUILD'
	    // Advice: don't define M2_HOME in general. Maven will autodetect its root fine.
		withEnv(["JAVA_HOME=${ tool 'JDK_8' }", "PATH+MAVEN=${tool 'M3'}/bin:${env.JAVA_HOME}/bin"]) 
		{
		    // Apache Maven related side notes:
		    // --batch-mode : recommended in CI to inform maven to not run in interactive mode (less logs)
		    // -V : strongly recommended in CI, will display the JDK and Maven versions in use.
		    //      Very useful to be quickly sure the selected versions were the ones you think.
		    // -U : force maven to update snapshots each time (default : once an hour, makes no sense in CI).
		    // -Dsurefire.useFile=false : useful in CI. Displays test errors in the logs directly (instead of
		    //                            having to crawl the workspace files to see the cause).
		    // sh "mvn --batch-mode -V -U -e clean deploy -Dsurefire.useFile=false"
		   
		  
		   //def mvnHome = tool 'M3'
		   //sh "${mvnHome}/bin/mvn -B verify package"
		   
		   sh "mvn --batch-mode -V -U -e clean verify install -Dsurefire.useFile=false"
		   echo 'Hello from build stage'
	   }
   
   stage 'FINISHED'
	   echo 'We are done. This was last stage'
}