package fri.diplomska.diplomska.models.data;

import fri.diplomska.diplomska.models.request.DeploymentRequestDataModel;

import javax.validation.constraints.NotBlank;

public class DeploymentDataModel {

    public DeploymentDataModel() { }

    public DeploymentDataModel(DeploymentRequestDataModel request) {
        this.imageName = request.getImageName();
        this.imageTag = request.getImageTag();
        this.deploymentName = request.getDeploymentName();
        this.containerPort = request.getContainerPort();
    }

    @NotBlank(message = "Image name is mandatory")
    private String imageName;

    @NotBlank(message = "Image tag is mandatory")
    private String imageTag;

    @NotBlank(message = "Deployment name is mandatory")
    private String deploymentName;

    private int containerPort;

    private String namespace;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getDeploymentName() {
        return deploymentName;
    }

    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    public int getContainerPort() {
        return containerPort;
    }

    public void setContainerPort(int containerPort) {
        this.containerPort = containerPort;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}