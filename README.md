# SAP Commerce Cloud with Data Hub Sample Repository

This sample repository contains the files and folders that are required to set up SAP Commerce Cloud with Data Hub.  You can clone this repository and then follow the instructions in the readme to update the example files with your specific details. 

When your files are ready, push them to your SAP Commerce Cloud repository.  

# Requirements

- You have a public-facing code repository.
- You have an active SAP Commerce Cloud subscription.
- You have a license for SAP Commerce 6.7 or higher
- You have a license for Data Hub on Commerce Cloud version 6.7 or higher.
- You have not set up SAP Commerce Cloud yet.

# Supported Versions

You can find the supported SAP Commerce versions listed in the [Compatibility help topic](https://help.sap.com/viewer/1be46286b36a4aa48205be5a96240672/SHIP/en-US/31ac209eb08f41bc92e9bbe5772fb949.html).

# Download and Installation
Not applicable.

# Configuration

These instructions walk you through the process of cloning the repository and then updating the sample files with your specific requirements. 

The following folders and files are included in the sample repository.

Root level 
- core-customize folder: The folder that contains all of the folders and files that support Commerce Cloud.
- datahub folder: The folder that contains all of the folders and files that support Data Hub.

core-customize folder
- manifest.json: The Commerce Cloud manifest.json file, which defines Commerce Platform customizations.
- kiwi folder: An example custom extension.
- tiger folder: An example custom extension.
- other sample manifests: A collection of tested and verified manifest files that you can use as starting points for your Commerce Cloud environments.

datahub folder
- manifest.json: The Data Hub manifest.json file that defines the Data Hub application and extensions.
- ccv2 example folder: A generic folder that you can build out for custom extensions.
- config folder: The folder that contains the Data Hub configuration files and folders.
- README.md: Specific readme for Data Hub specific configuration.

### Clone Repository

Clone the sample repository ([instructions can be found here](https://help.github.com/articles/cloning-a-repository/)). The files are copied to your local machine.

### Update the Custom Extensions

1. If you don’t have custom extensions, you can delete the kiwi & tiger sample folders.
2. If you do have custom extensions, create a folder for each custom extension and add your extension files.
3. List the custom extensions in the manifest.json file that is inside the core-customize directory. 
4. If you have custom extensions with dependencies, list the source extension first, then the dependent extension. Extensions are built in the order in which they appear in the manifest file.

### Update the Commerce Cloud manifest.json

1. Open the manifest.json file inside the core-customize folder. 
2. Update the “version” with the version of SAP Commerce that you plan to use. Refer to the Supported Versions section of this readme for more information.
3. Save the changes.

### Prepare to Push the Sample Repository
 
1. In the sample repository, verify that you have the following files in the *core-customize* folder.
 - manifest.json:  This is the manifest.json for Commerce Cloud.
 - \<custom extension> folders (optional)
2. Verify that you have the following files in the *datahub* folder.
 - manifest.json: This is the manifest.json for Data Hub.
 - \<config> folder: This is the folder which contains configuration information specific to Data Hub (see [Data Hub](datahub/README.md) readme for details). 
 - \<custom extension> folders (optional)

### Push the Commerce Cloud Configuration to Code Repository

Push the core-customize & datahub folder from your local machine to the root level of your Commerce Cloud repository.  

### Access the Cloud Portal

Log in to the Cloud Portal and verify that your code repository is connected.

1. From a supported browser, log in to https://portal.commerce.ondemand.com. For more information, see [Accessing the Cloud Portal](https://help.sap.com/viewer/0c2050f6d31f49ddb6eba18509060ae5/SHIP/en-US/bc745004669445478d0c0505d77e096c.html).
2. Select *Repository* and verify that you are connected to the correct code repository.
3. Find the environments that were provisioned for your subscription.
3. Create a new build.
4. Deploy the build to the environment using the *Initialize Database* option.

### Final Steps - Validating an example Electronics Storefront

Use the Cloud Portal to create a build and then deploy the build to an environment. 

1. After the build is deployed, you can find the 'Storefront' endpoint in the *Environments* page of the Cloud Portal listed under *Public Endpoints*.
2. Click on the *Storefront* hyperlink to access the details page for endpoint.
3. Either add an IP Filter Set for your IP address OR change the Base Rule from 'Deny All' to 'Allow All' in order to receive traffic to this example storefront.
4. Save the changes.
5. Click on the URL listed next to the *Storefront* public endpoint. You will receive a server error.
6. In your browser's address, append the endpoint address with */?site=electronics* and reload the page
7. Verify that you see a basic electronics storefront.

After the build is deployed, you can find the Data Hub endpoint in the Environments page of the Cloud Portal.

# Limitations

The repository must be a public-facing repository.  You cannot use a private repository to host SAP Commerce Cloud configurations. 

# Known Issues

There are no known issues at this time.

# How to Obtain Support

This repository is provided "as-is"; no support is available.

Find more information about SAP Commerce Cloud Setup on our [help site](https://help.sap.com/viewer/1be46286b36a4aa48205be5a96240672/SHIP/en-US/76450bc02bdf492689ca5e6d35c670e6.html).

# License
Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
This file is licensed under the “SAP Sample Code License” except as noted otherwise in the [LICENSE file](https://github.wdf.sap.corp/staging-for-SAP-samples-public/cloud-commerce-sample-setup/blob/master/LICENSE).






