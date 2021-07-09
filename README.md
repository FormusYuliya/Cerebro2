#Python script for customizing Allure report#

**Using scripts:**
On current dericetory you can find 2 independent scrips: 
-*the "report_customizer"*
-*the "run_r_api_dottie"*

The report_customizer.bat script modifies the default report.json file. And allows to create of Allure reports with prettified reports with steps detalization
#
**For running report_customizer script set the next commend into the  command line** *'python report_customizer.py -t "PATH TO GENERATED ALLURE JSON-REPORT"'*
#

The run_r_api_dottie script might be used for running test cases automatically on the local computer or it can be modified for running it on the bamboo CI/CD

#
**For running run_r_api_dottie script set the next commend into the  command line** *python run_r_api_dottie.py -r "PATH TO THE READY API TESTRUNNER BAT FILE" -d "PATH TO THE PROJECT DIRECTORY" -f "PATH TO THE ALLURE REPORTS DIRECTORY" -a "PATH TO THE ALLURE BAT FILE" -e ENV -t THREADS_NUM -s "TEST_SUITE" -l GIT_LOGIN -p "GIT_PASSWORD" -L SPLUNK_LOGIN -P "SPLUNK_PASSWORD"*
#

**For running HELP set the next command into the command line** *'python run_r_api_dottie.py -h' or  'python report_customizer.py -h'* 
