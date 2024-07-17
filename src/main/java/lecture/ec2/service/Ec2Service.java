package lecture.ec2.service;

import lecture.ec2.utils.Ec2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesRequest;
import software.amazon.awssdk.services.ec2.model.DescribeInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Instance;

import java.io.IOException;

@Service
public class Ec2Service {

    private final  Ec2Client ec2;
    private final String instanceId;

    public Ec2Service() throws IOException {
        String region = Ec2Util.getRegion();
        this.ec2 = Ec2Client.builder()
                .region(Region.of(region))
                .build();
        instanceId = Ec2Util.getInstanceId();
    }


    public String getInstanceMetaData(){
        DescribeInstancesRequest request = DescribeInstancesRequest.builder()
                .instanceIds(instanceId)
                .build();

        DescribeInstancesResponse response = ec2.describeInstances(request);
        Instance instance = response.reservations().get(0).instances().get(0);

        return instance.toString();
    }
}
