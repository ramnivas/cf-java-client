/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.reactor.client.v2.spaces;

import org.cloudfoundry.client.v2.applications.ApplicationEntity;
import org.cloudfoundry.client.v2.applications.ApplicationResource;
import org.cloudfoundry.client.v2.domains.Domain;
import org.cloudfoundry.client.v2.domains.DomainEntity;
import org.cloudfoundry.client.v2.domains.DomainResource;
import org.cloudfoundry.client.v2.events.EventEntity;
import org.cloudfoundry.client.v2.events.EventResource;
import org.cloudfoundry.client.v2.jobs.JobEntity;
import org.cloudfoundry.client.v2.routes.Route;
import org.cloudfoundry.client.v2.routes.RouteEntity;
import org.cloudfoundry.client.v2.routes.RouteResource;
import org.cloudfoundry.client.v2.securitygroups.RuleEntity;
import org.cloudfoundry.client.v2.securitygroups.SecurityGroupEntity;
import org.cloudfoundry.client.v2.securitygroups.SecurityGroupResource;
import org.cloudfoundry.client.v2.serviceinstances.LastOperation;
import org.cloudfoundry.client.v2.serviceinstances.UnionServiceInstanceEntity;
import org.cloudfoundry.client.v2.serviceinstances.UnionServiceInstanceResource;
import org.cloudfoundry.client.v2.services.ServiceEntity;
import org.cloudfoundry.client.v2.services.ServiceResource;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceAuditorByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceAuditorByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceAuditorRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceAuditorResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceDeveloperByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceDeveloperByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceDeveloperRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceDeveloperResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceManagerByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceManagerByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceManagerRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceManagerResponse;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceSecurityGroupRequest;
import org.cloudfoundry.client.v2.spaces.AssociateSpaceSecurityGroupResponse;
import org.cloudfoundry.client.v2.spaces.CreateSpaceRequest;
import org.cloudfoundry.client.v2.spaces.CreateSpaceResponse;
import org.cloudfoundry.client.v2.spaces.DeleteSpaceRequest;
import org.cloudfoundry.client.v2.spaces.DeleteSpaceResponse;
import org.cloudfoundry.client.v2.spaces.GetSpaceRequest;
import org.cloudfoundry.client.v2.spaces.GetSpaceResponse;
import org.cloudfoundry.client.v2.spaces.GetSpaceSummaryRequest;
import org.cloudfoundry.client.v2.spaces.GetSpaceSummaryResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceApplicationsRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceApplicationsResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceAuditorsRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceAuditorsResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceDevelopersRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceDevelopersResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceDomainsRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceDomainsResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceEventsRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceEventsResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceManagersRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceManagersResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceRoutesRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceRoutesResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceSecurityGroupsRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceSecurityGroupsResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceServiceInstancesRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceServiceInstancesResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceServicesRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceServicesResponse;
import org.cloudfoundry.client.v2.spaces.ListSpaceUserRolesRequest;
import org.cloudfoundry.client.v2.spaces.ListSpaceUserRolesResponse;
import org.cloudfoundry.client.v2.spaces.ListSpacesRequest;
import org.cloudfoundry.client.v2.spaces.ListSpacesResponse;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceAuditorByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceAuditorByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceAuditorRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceDeveloperByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceDeveloperByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceDeveloperRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceManagerByUsernameRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceManagerByUsernameResponse;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceManagerRequest;
import org.cloudfoundry.client.v2.spaces.RemoveSpaceSecurityGroupRequest;
import org.cloudfoundry.client.v2.spaces.SpaceApplicationSummary;
import org.cloudfoundry.client.v2.spaces.SpaceEntity;
import org.cloudfoundry.client.v2.spaces.SpaceResource;
import org.cloudfoundry.client.v2.spaces.UpdateSpaceRequest;
import org.cloudfoundry.client.v2.spaces.UpdateSpaceResponse;
import org.cloudfoundry.client.v2.spaces.UserSpaceRoleEntity;
import org.cloudfoundry.client.v2.spaces.UserSpaceRoleResource;
import org.cloudfoundry.client.v2.users.UserEntity;
import org.cloudfoundry.client.v2.users.UserResource;
import org.cloudfoundry.reactor.InteractionContext;
import org.cloudfoundry.reactor.TestRequest;
import org.cloudfoundry.reactor.TestResponse;
import org.cloudfoundry.reactor.client.AbstractClientApiTest;
import org.cloudfoundry.util.StringMap;
import reactor.core.publisher.Mono;

import static io.netty.handler.codec.http.HttpMethod.DELETE;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpMethod.PUT;
import static io.netty.handler.codec.http.HttpResponseStatus.ACCEPTED;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

import org.cloudfoundry.client.v2.Metadata;
import org.cloudfoundry.client.v2.serviceinstances.Plan;

import org.cloudfoundry.client.v2.serviceinstances.Service;
import static org.cloudfoundry.client.v2.serviceinstances.ServiceInstance.builder;

public final class ReactorSpacesTest {

    public static final class AssociateAuditor extends AbstractClientApiTest<AssociateSpaceAuditorRequest, AssociateSpaceAuditorResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/auditors/test-auditor-id")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_auditors_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceAuditorResponse getResponse() {
            return AssociateSpaceAuditorResponse.builder()
                .metadata(Metadata.builder()
                    .id("9639c996-9005-4b70-b852-d40f346d58dc")
                    .url("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc")
                    .createdAt("2015-07-27T22:43:07Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-59")
                    .organizationId("bc168e1d-b399-4624-b7f6-fbe64eeb870f")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/bc168e1d-b399-4624-b7f6-fbe64eeb870f")
                    .developersUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/developers")
                    .managersUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/managers")
                    .auditorsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/auditors")
                    .applicationsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/apps")
                    .routesUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/routes")
                    .domainsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/domains")
                    .serviceInstancesUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/service_instances")
                    .applicationEventsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/app_events")
                    .eventsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/events")
                    .securityGroupsUrl("/v2/spaces/9639c996-9005-4b70-b852-d40f346d58dc/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceAuditorRequest getValidRequest() throws Exception {
            return AssociateSpaceAuditorRequest.builder()
                .spaceId("test-space-id")
                .auditorId("test-auditor-id")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceAuditorResponse> invoke(AssociateSpaceAuditorRequest request) {
            return this.spaces.associateAuditor(request);
        }

    }

    public static final class AssociateAuditorByUsername extends AbstractClientApiTest<AssociateSpaceAuditorByUsernameRequest, AssociateSpaceAuditorByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/auditors")
                    .payload("fixtures/client/v2/spaces/PUT_{id}_auditors_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_auditors_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceAuditorByUsernameResponse getResponse() {
            return AssociateSpaceAuditorByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("873193ee-878c-436f-80bd-10d68927937d")
                    .url("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d")
                    .createdAt("2015-11-30T23:38:28Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .allowSsh(true)
                    .applicationEventsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/app_events")
                    .applicationsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/apps")
                    .auditorsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/auditors")
                    .developersUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/developers")
                    .domainsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/domains")
                    .eventsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/events")
                    .managersUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/managers")
                    .name("name-101")
                    .organizationId("5fddaf61-092d-4b33-9490-8350963db89e")
                    .organizationUrl("/v2/organizations/5fddaf61-092d-4b33-9490-8350963db89e")
                    .routesUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/routes")
                    .securityGroupsUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/security_groups")
                    .serviceInstancesUrl("/v2/spaces/873193ee-878c-436f-80bd-10d68927937d/service_instances")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceAuditorByUsernameRequest getValidRequest() throws Exception {
            return AssociateSpaceAuditorByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("user@example.com")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceAuditorByUsernameResponse> invoke(AssociateSpaceAuditorByUsernameRequest request) {
            return this.spaces.associateAuditorByUsername(request);
        }

    }

    public static final class AssociateDeveloper extends AbstractClientApiTest<AssociateSpaceDeveloperRequest, AssociateSpaceDeveloperResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/developers/test-developer-id")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_developers_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceDeveloperResponse getResponse() {
            return AssociateSpaceDeveloperResponse.builder()
                .metadata(Metadata.builder()
                    .id("6f8f8e0d-54f2-4736-a08e-1044fcf061d3")
                    .url("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3")
                    .createdAt("2015-07-27T22:43:07Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-68")
                    .organizationId("5b556f7c-63f5-43e5-9522-c4fec533b09d")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/5b556f7c-63f5-43e5-9522-c4fec533b09d")
                    .developersUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/developers")
                    .managersUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/managers")
                    .auditorsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/auditors")
                    .applicationsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/apps")
                    .routesUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/routes")
                    .domainsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/domains")
                    .serviceInstancesUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/service_instances")
                    .applicationEventsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/app_events")
                    .eventsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/events")
                    .securityGroupsUrl("/v2/spaces/6f8f8e0d-54f2-4736-a08e-1044fcf061d3/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceDeveloperRequest getValidRequest() throws Exception {
            return AssociateSpaceDeveloperRequest.builder()
                .spaceId("test-space-id")
                .developerId("test-developer-id")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceDeveloperResponse> invoke(AssociateSpaceDeveloperRequest request) {
            return this.spaces.associateDeveloper(request);
        }

    }

    public static final class AssociateManager extends AbstractClientApiTest<AssociateSpaceManagerRequest, AssociateSpaceManagerResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/managers/test-manager-id")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_managers_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceManagerResponse getResponse() {
            return AssociateSpaceManagerResponse.builder()
                .metadata(Metadata.builder()
                    .id("542943ff-a40b-4004-9559-434b0169508c")
                    .url("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c")
                    .createdAt("2015-07-27T22:43:07Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-85")
                    .organizationId("0a68fcd5-dc1c-48d0-98dc-33008ce0d7ce")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/0a68fcd5-dc1c-48d0-98dc-33008ce0d7ce")
                    .developersUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/developers")
                    .managersUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/managers")
                    .auditorsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/auditors")
                    .applicationsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/apps")
                    .routesUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/routes")
                    .domainsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/domains")
                    .serviceInstancesUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/service_instances")
                    .applicationEventsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/app_events")
                    .eventsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/events")
                    .securityGroupsUrl("/v2/spaces/542943ff-a40b-4004-9559-434b0169508c/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceManagerRequest getValidRequest() throws Exception {
            return AssociateSpaceManagerRequest.builder()
                .spaceId("test-space-id")
                .managerId("test-manager-id")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceManagerResponse> invoke(AssociateSpaceManagerRequest request) {
            return this.spaces.associateManager(request);
        }

    }

    public static final class AssociateSecurityGroup extends AbstractClientApiTest<AssociateSpaceSecurityGroupRequest, AssociateSpaceSecurityGroupResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/security_groups/test-security-group-id")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_security_group_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceSecurityGroupResponse getResponse() {
            return AssociateSpaceSecurityGroupResponse.builder()
                .metadata(Metadata.builder()
                    .id("c9424692-395b-403b-90e6-10049bbd9e23")
                    .url("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23")
                    .createdAt("2015-07-27T22:43:06Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-39")
                    .organizationId("67096164-bdcf-4b53-92e1-a2991882a066")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/67096164-bdcf-4b53-92e1-a2991882a066")
                    .developersUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/developers")
                    .managersUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/managers")
                    .auditorsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/auditors")
                    .applicationsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/apps")
                    .routesUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/routes")
                    .domainsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/domains")
                    .serviceInstancesUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/service_instances")
                    .applicationEventsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/app_events")
                    .eventsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/events")
                    .securityGroupsUrl("/v2/spaces/c9424692-395b-403b-90e6-10049bbd9e23/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceSecurityGroupRequest getValidRequest() throws Exception {
            return AssociateSpaceSecurityGroupRequest.builder()
                .spaceId("test-space-id")
                .securityGroupId("test-security-group-id")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceSecurityGroupResponse> invoke(AssociateSpaceSecurityGroupRequest request) {
            return this.spaces.associateSecurityGroup(request);
        }

    }

    public static final class AssociateSpaceDeveloperByUsername extends AbstractClientApiTest<AssociateSpaceDeveloperByUsernameRequest, AssociateSpaceDeveloperByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/developers")
                    .payload("fixtures/client/v2/spaces/PUT_{id}_developers_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_developers_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceDeveloperByUsernameResponse getResponse() {
            return AssociateSpaceDeveloperByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("b6d11f17-1cea-4c00-a951-fef3223b8c84")
                    .url("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84")
                    .createdAt("2015-11-30T23:38:27Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-58")
                    .organizationId("b13bbebe-427e-424d-8820-2937f7e218d5")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/b13bbebe-427e-424d-8820-2937f7e218d5")
                    .developersUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/developers")
                    .managersUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/managers")
                    .auditorsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/auditors")
                    .applicationsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/apps")
                    .routesUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/routes")
                    .domainsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/domains")
                    .serviceInstancesUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/service_instances")
                    .applicationEventsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/app_events")
                    .eventsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/events")
                    .securityGroupsUrl("/v2/spaces/b6d11f17-1cea-4c00-a951-fef3223b8c84/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceDeveloperByUsernameRequest getValidRequest() throws Exception {
            return AssociateSpaceDeveloperByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("user@example.com")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceDeveloperByUsernameResponse> invoke(AssociateSpaceDeveloperByUsernameRequest request) {
            return this.spaces.associateDeveloperByUsername(request);
        }

    }

    public static final class AssociateSpaceManagerByUsername extends AbstractClientApiTest<AssociateSpaceManagerByUsernameRequest, AssociateSpaceManagerByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id/managers")
                    .payload("fixtures/client/v2/spaces/PUT_{id}_managers_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_managers_response.json")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceManagerByUsernameResponse getResponse() {
            return AssociateSpaceManagerByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("4351f97b-3485-4738-821b-5bf77bed44eb")
                    .url("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb")
                    .createdAt("2015-11-30T23:38:28Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-98")
                    .organizationId("a488910d-2d69-46a2-bf6e-319248e03705")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/a488910d-2d69-46a2-bf6e-319248e03705")
                    .developersUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/developers")
                    .managersUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/managers")
                    .auditorsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/auditors")
                    .applicationsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/apps")
                    .routesUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/routes")
                    .domainsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/domains")
                    .serviceInstancesUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/service_instances")
                    .applicationEventsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/app_events")
                    .eventsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/events")
                    .securityGroupsUrl("/v2/spaces/4351f97b-3485-4738-821b-5bf77bed44eb/security_groups")
                    .build())
                .build();
        }

        @Override
        protected AssociateSpaceManagerByUsernameRequest getValidRequest() throws Exception {
            return AssociateSpaceManagerByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("user@example.com")
                .build();
        }

        @Override
        protected Mono<AssociateSpaceManagerByUsernameResponse> invoke(AssociateSpaceManagerByUsernameRequest request) {
            return this.spaces.associateManagerByUsername(request);
        }

    }

    public static final class Create extends AbstractClientApiTest<CreateSpaceRequest, CreateSpaceResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(POST).path("/v2/spaces")
                    .payload("fixtures/client/v2/spaces/POST_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/POST_response.json")
                    .build())
                .build();
        }

        @Override
        protected CreateSpaceResponse getResponse() {
            return CreateSpaceResponse.builder()
                .metadata(Metadata.builder()
                    .id("d29dc30c-793c-49a6-97fe-9aff75dcbd12")
                    .url("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12")
                    .createdAt("2015-07-27T22:43:08Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("development")
                    .organizationId("c523070c-3006-4715-86dd-414afaecd949")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/c523070c-3006-4715-86dd-414afaecd949")
                    .developersUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/developers")
                    .managersUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/managers")
                    .auditorsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/auditors")
                    .applicationsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/apps")
                    .routesUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/routes")
                    .domainsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/domains")
                    .serviceInstancesUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/service_instances")
                    .applicationEventsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/app_events")
                    .eventsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/events")
                    .securityGroupsUrl("/v2/spaces/d29dc30c-793c-49a6-97fe-9aff75dcbd12/security_groups")
                    .build())
                .build();
        }

        @Override
        protected CreateSpaceRequest getValidRequest() throws Exception {
            return CreateSpaceRequest.builder()
                .name("development")
                .organizationId("c523070c-3006-4715-86dd-414afaecd949")
                .build();
        }

        @Override
        protected Mono<CreateSpaceResponse> invoke(CreateSpaceRequest request) {
            return this.spaces.create(request);
        }

    }

    public static final class Delete extends AbstractClientApiTest<DeleteSpaceRequest, DeleteSpaceResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id")
                    .build())
                .response(TestResponse.builder()
                    .status(NO_CONTENT)
                    .build())
                .build();
        }

        @Override
        protected DeleteSpaceResponse getResponse() {
            return null;
        }

        @Override
        protected DeleteSpaceRequest getValidRequest() throws Exception {
            return DeleteSpaceRequest.builder()
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<DeleteSpaceResponse> invoke(DeleteSpaceRequest request) {
            return this.spaces.delete(request);
        }

    }

    public static final class DeleteAsync extends AbstractClientApiTest<DeleteSpaceRequest, DeleteSpaceResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id?async=true")
                    .build())
                .response(TestResponse.builder()
                    .status(ACCEPTED)
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_async_response.json")
                    .build())
                .build();
        }

        @Override
        protected DeleteSpaceResponse getResponse() {
            return DeleteSpaceResponse.builder()
                .metadata(Metadata.builder()
                    .id("2d9707ba-6f0b-4aef-a3de-fe9bdcf0c9d1")
                    .createdAt("2016-02-02T17:16:31Z")
                    .url("/v2/jobs/2d9707ba-6f0b-4aef-a3de-fe9bdcf0c9d1")
                    .build())
                .entity(JobEntity.builder()
                    .id("2d9707ba-6f0b-4aef-a3de-fe9bdcf0c9d1")
                    .status("queued")
                    .build())
                .build();
        }

        @Override
        protected DeleteSpaceRequest getValidRequest() throws Exception {
            return DeleteSpaceRequest.builder()
                .async(true)
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<DeleteSpaceResponse> invoke(DeleteSpaceRequest request) {
            return this.spaces.delete(request);
        }

    }

    public static final class Get extends AbstractClientApiTest<GetSpaceRequest, GetSpaceResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected GetSpaceResponse getResponse() {
            return GetSpaceResponse.builder()
                .metadata(Metadata.builder()
                    .id("0f102457-c1fc-42e5-9c81-c7be2bc65dcd")
                    .url("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd")
                    .createdAt("2015-07-27T22:43:08Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-108")
                    .organizationId("525a31fb-bc2b-4f7f-865e-1c93b42a6762")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/525a31fb-bc2b-4f7f-865e-1c93b42a6762")
                    .developersUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/developers")
                    .managersUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/managers")
                    .auditorsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/auditors")
                    .applicationsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/apps")
                    .routesUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/routes")
                    .domainsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/domains")
                    .serviceInstancesUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/service_instances")
                    .applicationEventsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/app_events")
                    .eventsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/events")
                    .securityGroupsUrl("/v2/spaces/0f102457-c1fc-42e5-9c81-c7be2bc65dcd/security_groups")
                    .build())
                .build();
        }

        @Override
        protected GetSpaceRequest getValidRequest() throws Exception {
            return GetSpaceRequest.builder()
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<GetSpaceResponse> invoke(GetSpaceRequest request) {
            return this.spaces.get(request);
        }

    }

    public static final class GetSummary extends AbstractClientApiTest<GetSpaceSummaryRequest, GetSpaceSummaryResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/summary")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_summary_response.json")
                    .build())
                .build();
        }

        @Override
        protected GetSpaceSummaryResponse getResponse() {
            return GetSpaceSummaryResponse.builder()
                .id("c6473a38-92f4-4595-9462-01af4c4b1893")
                .name("name-159")
                .application(SpaceApplicationSummary.builder()
                    .id("e378968e-89d4-4e84-bce5-ee997daea898")
                    .url("host-1.domain-5.example.com")
                    .route(Route.builder()
                        .id("812c7de6-b14f-4193-8c95-74449c5ae0e4")
                        .host("host-1")
                        .path("")
                        .domain(Domain.builder()
                            .id("0a7c349f-84c4-4fde-867d-a73814c66168")
                            .name("domain-5.example.com")
                            .build())
                        .build())
                    .serviceCount(1)
                    .serviceName("name-162")
                    .runningInstances(0)
                    .name("name-165")
                    .production(false)
                    .spaceId("c6473a38-92f4-4595-9462-01af4c4b1893")
                    .stackId("eefe21a1-6878-40d1-8485-80a88cfdbbe4")
                    .memory(1024)
                    .instances(1)
                    .diskQuota(1024)
                    .state("STOPPED")
                    .version("2bea31d1-b0b7-467d-9794-62dd7f0dd200")
                    .console(false)
                    .packageState("PENDING")
                    .healthCheckType("port")
                    .diego(false)
                    .packageUpdatedAt("2016-04-22T19:33:13Z")
                    .detectedStartCommand("")
                    .enableSsh(true)
                    .dockerCredentialsJson("redacted_message", "[PRIVATE DATA HIDDEN]")
                    .build())
                .service(builder()
                    .id("a049e5e8-8597-469e-b1c6-ddb8eb2c0af0")
                    .name("name-162")
                    .boundApplicationCount(1)
                    .lastOperation(LastOperation.builder()
                        .type("create")
                        .state("succeeded")
                        .description("description goes here")
                        .updatedAt("2016-04-22T19:33:13Z")
                        .createdAt("2016-04-22T19:33:13Z")
                        .build())
                    .servicePlan(Plan.builder()
                        .id("b9cb2cd3-2761-4e9b-9215-d64840ee3bf5")
                        .name("name-163")
                        .service(Service.builder()
                            .id("00f143db-8b79-4e4a-bf03-021cf93131f4")
                            .label("label-16")
                            .build())
                        .build())
                    .build())
                .build();
        }

        @Override
        protected GetSpaceSummaryRequest getValidRequest() throws Exception {
            return GetSpaceSummaryRequest.builder()
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<GetSpaceSummaryResponse> invoke(GetSpaceSummaryRequest request) {
            return this.spaces.getSummary(request);
        }

    }

    public static final class List extends AbstractClientApiTest<ListSpacesRequest, ListSpacesResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces?q=name%20IN%20test-name&page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpacesResponse getResponse() {
            return ListSpacesResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(SpaceResource.builder()
                    .metadata(Metadata.builder()
                        .id("b4293b09-8316-472c-a29a-6468a3adff59")
                        .url("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59")
                        .createdAt("2015-07-27T22:43:08Z")
                        .build())
                    .entity(SpaceEntity.builder()
                        .name("name-111")
                        .organizationId("3ce736dd-3b8c-4f64-acab-ed76488b79a3")
                        .allowSsh(true)
                        .organizationUrl("/v2/organizations/3ce736dd-3b8c-4f64-acab-ed76488b79a3")
                        .developersUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/developers")
                        .managersUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/managers")
                        .auditorsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/auditors")
                        .applicationsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/apps")
                        .routesUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/routes")
                        .domainsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/domains")
                        .serviceInstancesUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/service_instances")
                        .applicationEventsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/app_events")
                        .eventsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/events")
                        .securityGroupsUrl("/v2/spaces/b4293b09-8316-472c-a29a-6468a3adff59/security_groups")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpacesRequest getValidRequest() throws Exception {
            return ListSpacesRequest.builder()
                .name("test-name")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpacesResponse> invoke(ListSpacesRequest request) {
            return this.spaces.list(request);
        }

    }

    public static final class ListApplications extends AbstractClientApiTest<ListSpaceApplicationsRequest, ListSpaceApplicationsResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/apps?q=name%20IN%20test-name&page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_apps_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceApplicationsResponse getResponse() {
            return ListSpaceApplicationsResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(ApplicationResource.builder()
                    .metadata(Metadata.builder()
                        .id("4ee31730-3c0e-4ec6-8329-26e727ab8ccd")
                        .url("/v2/apps/4ee31730-3c0e-4ec6-8329-26e727ab8ccd")
                        .createdAt("2015-07-27T22:43:08Z")
                        .updatedAt("2015-07-27T22:43:08Z")
                        .build())
                    .entity(ApplicationEntity.builder()
                        .name("name-103")
                        .production(false)
                        .spaceId("ca816a1b-ed3e-4ea8-bda2-2031d2e5b89f")
                        .stackId("e458a99f-53a4-4da4-b78a-5f2eb212cc47")
                        .memory(1024)
                        .instances(1)
                        .diskQuota(1024)
                        .state("STOPPED")
                        .version("cc21d137-45d6-4687-ab71-8288ac0e5724")
                        .console(false)
                        .packageState("PENDING")
                        .healthCheckType("port")
                        .diego(false)
                        .packageUpdatedAt("2015-07-27T22:43:08Z")
                        .detectedStartCommand("")
                        .enableSsh(true)
                        .dockerCredentialsJson("redacted_message", "[PRIVATE DATA HIDDEN]")
                        .spaceUrl("/v2/spaces/ca816a1b-ed3e-4ea8-bda2-2031d2e5b89f")
                        .stackUrl("/v2/stacks/e458a99f-53a4-4da4-b78a-5f2eb212cc47")
                        .eventsUrl("/v2/apps/4ee31730-3c0e-4ec6-8329-26e727ab8ccd/events")
                        .serviceBindingsUrl("/v2/apps/4ee31730-3c0e-4ec6-8329-26e727ab8ccd/service_bindings")
                        .routesUrl("/v2/apps/4ee31730-3c0e-4ec6-8329-26e727ab8ccd/routes")
                        .routeMappingsUrl("/v2/apps/4ee31730-3c0e-4ec6-8329-26e727ab8ccd/route_mappings")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceApplicationsRequest getValidRequest() throws Exception {
            return ListSpaceApplicationsRequest.builder()
                .spaceId("test-space-id")
                .name("test-name")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceApplicationsResponse> invoke(ListSpaceApplicationsRequest request) {
            return this.spaces.listApplications(request);
        }

    }

    public static final class ListAuditors extends AbstractClientApiTest<ListSpaceAuditorsRequest, ListSpaceAuditorsResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/auditors?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_auditors_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceAuditorsResponse getResponse() {
            return ListSpaceAuditorsResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(UserResource.builder()
                    .metadata(Metadata.builder()
                        .id("uaa-id-15")
                        .url("/v2/users/uaa-id-15")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(UserEntity.builder()
                        .admin(false)
                        .active(false)
                        .defaultSpaceId(null)
                        .username("auditor@example.com")
                        .spacesUrl("/v2/users/uaa-id-15/spaces")
                        .organizationsUrl("/v2/users/uaa-id-15/organizations")
                        .managedOrganizationsUrl("/v2/users/uaa-id-15/managed_organizations")
                        .billingManagedOrganizationsUrl("/v2/users/uaa-id-15/billing_managed_organizations")
                        .auditedOrganizationsUrl("/v2/users/uaa-id-15/audited_organizations")
                        .managedSpacesUrl("/v2/users/uaa-id-15/managed_spaces")
                        .auditedSpacesUrl("/v2/users/uaa-id-15/audited_spaces")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceAuditorsRequest getValidRequest() throws Exception {
            return ListSpaceAuditorsRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceAuditorsResponse> invoke(ListSpaceAuditorsRequest request) {
            return this.spaces.listAuditors(request);
        }
    }

    public static final class ListDevelopers extends AbstractClientApiTest<ListSpaceDevelopersRequest, ListSpaceDevelopersResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/developers?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_developers_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceDevelopersResponse getResponse() {
            return ListSpaceDevelopersResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(UserResource.builder()
                    .metadata(Metadata.builder()
                        .id("uaa-id-24")
                        .url("/v2/users/uaa-id-24")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(UserEntity.builder()
                        .admin(false)
                        .active(false)
                        .defaultSpaceId(null)
                        .username("developer@example.com")
                        .spacesUrl("/v2/users/uaa-id-24/spaces")
                        .organizationsUrl("/v2/users/uaa-id-24/organizations")
                        .managedOrganizationsUrl("/v2/users/uaa-id-24/managed_organizations")
                        .billingManagedOrganizationsUrl("/v2/users/uaa-id-24/billing_managed_organizations")
                        .auditedOrganizationsUrl("/v2/users/uaa-id-24/audited_organizations")
                        .managedSpacesUrl("/v2/users/uaa-id-24/managed_spaces")
                        .auditedSpacesUrl("/v2/users/uaa-id-24/audited_spaces")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceDevelopersRequest getValidRequest() throws Exception {
            return ListSpaceDevelopersRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceDevelopersResponse> invoke(ListSpaceDevelopersRequest request) {
            return this.spaces.listDevelopers(request);
        }

    }

    public static final class ListDomains extends AbstractClientApiTest<ListSpaceDomainsRequest, ListSpaceDomainsResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/domains?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_domains_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceDomainsResponse getResponse() {
            return ListSpaceDomainsResponse.builder()
                .totalResults(2)
                .totalPages(1)
                .resource(DomainResource.builder()
                    .metadata(Metadata.builder()
                        .id("08ac844a-e880-48ef-a90c-f95131582fcc")
                        .url("/v2/domains/08ac844a-e880-48ef-a90c-f95131582fcc")
                        .createdAt("2015-07-27T22:43:05Z")
                        .build())
                    .entity(DomainEntity.builder()
                        .name("customer-app-domain1.com")
                        .build())
                    .build())
                .resource(DomainResource.builder()
                    .metadata(Metadata.builder()
                        .id("973dcea1-5011-4bd0-aa9e-fa232bfaada7")
                        .url("/v2/domains/973dcea1-5011-4bd0-aa9e-fa232bfaada7")
                        .createdAt("2015-07-27T22:43:05Z")
                        .build())
                    .entity(DomainEntity.builder()
                        .name("customer-app-domain2.com")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceDomainsRequest getValidRequest() throws Exception {
            return ListSpaceDomainsRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceDomainsResponse> invoke(ListSpaceDomainsRequest request) {
            return this.spaces.listDomains(request);
        }
    }

    public static final class ListEvents extends AbstractClientApiTest<ListSpaceEventsRequest, ListSpaceEventsResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/events?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_events_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceEventsResponse getResponse() {
            return ListSpaceEventsResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(EventResource.builder()
                    .metadata(Metadata.builder()
                        .id("cbb42f10-2737-4522-95dc-3ada35056fa8")
                        .url("/v2/events/cbb42f10-2737-4522-95dc-3ada35056fa8")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(EventEntity.builder()
                        .type("audit.space.update")
                        .actor("uaa-id-10")
                        .actorType("user")
                        .actorName("user@example.com")
                        .actee("33d44b03-6203-47a7-b71c-9bf6fcaeb54a")
                        .acteeType("space")
                        .acteeName("name-56")
                        .timestamp("2015-07-27T22:43:07Z")
                        .metadatas(StringMap.builder()
                            .entry("request", StringMap.builder()
                                .entry("name", "new_name")
                                .build())
                            .build())
                        .spaceId("33d44b03-6203-47a7-b71c-9bf6fcaeb54a")
                        .organizationId("ab7dff90-0bc7-4ce0-be5b-b8ecc676bc4a")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceEventsRequest getValidRequest() throws Exception {
            return ListSpaceEventsRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceEventsResponse> invoke(ListSpaceEventsRequest request) {
            return this.spaces.listEvents(request);
        }

    }

    public static final class ListManagers extends AbstractClientApiTest<ListSpaceManagersRequest, ListSpaceManagersResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/managers?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_managers_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceManagersResponse getResponse() {
            return ListSpaceManagersResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(UserResource.builder()
                    .metadata(Metadata.builder()
                        .id("uaa-id-35")
                        .url("/v2/users/uaa-id-35")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(UserEntity.builder()
                        .admin(false)
                        .active(false)
                        .defaultSpaceId(null)
                        .username("manager@example.com")
                        .spacesUrl("/v2/users/uaa-id-35/spaces")
                        .organizationsUrl("/v2/users/uaa-id-35/organizations")
                        .managedOrganizationsUrl("/v2/users/uaa-id-35/managed_organizations")
                        .billingManagedOrganizationsUrl("/v2/users/uaa-id-35/billing_managed_organizations")
                        .auditedOrganizationsUrl("/v2/users/uaa-id-35/audited_organizations")
                        .managedSpacesUrl("/v2/users/uaa-id-35/managed_spaces")
                        .auditedSpacesUrl("/v2/users/uaa-id-35/audited_spaces")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceManagersRequest getValidRequest() throws Exception {
            return ListSpaceManagersRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceManagersResponse> invoke(ListSpaceManagersRequest request) {
            return this.spaces.listManagers(request);
        }

    }

    public static final class ListRoutes extends AbstractClientApiTest<ListSpaceRoutesRequest, ListSpaceRoutesResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/routes?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_routes_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceRoutesResponse getResponse() {
            return ListSpaceRoutesResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(RouteResource.builder()
                    .metadata(Metadata.builder()
                        .id("f975dbb5-f6d2-4cac-8014-49994ce01853")
                        .url("/v2/routes/f975dbb5-f6d2-4cac-8014-49994ce01853")
                        .createdAt("2016-03-17T21:41:14Z")
                        .build())
                    .entity(RouteEntity.builder()
                        .host("host-12")
                        .path("")
                        .domainId("b3ed68d6-c35f-4b17-bacb-ebc90da7fce1")
                        .spaceId("e3e2198a-e098-4473-b430-39a1d53a1d5b")
                        .port(0)
                        .domainUrl("/v2/domains/b3ed68d6-c35f-4b17-bacb-ebc90da7fce1")
                        .spaceUrl("/v2/spaces/e3e2198a-e098-4473-b430-39a1d53a1d5b")
                        .applicationsUrl("/v2/routes/f975dbb5-f6d2-4cac-8014-49994ce01853/apps")
                        .routeMappingsUrl("/v2/routes/f975dbb5-f6d2-4cac-8014-49994ce01853/route_mappings")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceRoutesRequest getValidRequest() throws Exception {
            return ListSpaceRoutesRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceRoutesResponse> invoke(ListSpaceRoutesRequest request) {
            return this.spaces.listRoutes(request);
        }

    }

    public static final class ListSecurityGroups extends AbstractClientApiTest<ListSpaceSecurityGroupsRequest, ListSpaceSecurityGroupsResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/security_groups?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_security_groups_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceSecurityGroupsResponse getResponse() {
            return ListSpaceSecurityGroupsResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(SecurityGroupResource.builder()
                    .metadata(Metadata.builder()
                        .id("a3728437-fe41-42c1-875c-b59cffc7498c")
                        .url("/v2/security_groups/a3728437-fe41-42c1-875c-b59cffc7498c")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(SecurityGroupEntity.builder()
                        .name("name-47")
                        .rule(RuleEntity.builder()
                            .destination("198.41.191.47/1")
                            .ports("8080")
                            .protocol("udp")
                            .build())
                        .runningDefault(false)
                        .spacesUrl("/v2/security_groups/a3728437-fe41-42c1-875c-b59cffc7498c/spaces")
                        .stagingDefault(false)
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceSecurityGroupsRequest getValidRequest() throws Exception {
            return ListSpaceSecurityGroupsRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceSecurityGroupsResponse> invoke(ListSpaceSecurityGroupsRequest request) {
            return this.spaces.listSecurityGroups(request);
        }

    }

    public static final class ListServiceInstances extends AbstractClientApiTest<ListSpaceServiceInstancesRequest, ListSpaceServiceInstancesResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/service_instances?page=-1&return_user_provided_service_instances=true")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_service_instances_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceServiceInstancesResponse getResponse() {
            return ListSpaceServiceInstancesResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(UnionServiceInstanceResource.builder()
                    .metadata(Metadata.builder()
                        .id("7046d37c-8a50-49d5-ba53-abb103a92142")
                        .url("/v2/service_instances/7046d37c-8a50-49d5-ba53-abb103a92142")
                        .createdAt("2015-07-27T22:43:08Z")
                        .build())
                    .entity(UnionServiceInstanceEntity.builder()
                        .name("name-97")
                        .credential("creds-key-52", "creds-val-52")
                        .servicePlanId("77157c85-203a-4fac-b9a3-003988ff879a")
                        .spaceId("aead50c9-0d45-410c-befd-431c8b7b3e30")
                        .type("managed_service_instance")
                        .spaceUrl("/v2/spaces/aead50c9-0d45-410c-befd-431c8b7b3e30")
                        .servicePlanUrl("/v2/service_plans/77157c85-203a-4fac-b9a3-003988ff879a")
                        .serviceBindingsUrl
                            ("/v2/service_instances/7046d37c-8a50-49d5-ba53-abb103a92142/service_bindings")
                        .serviceKeysUrl
                            ("/v2/service_instances/7046d37c-8a50-49d5-ba53-abb103a92142/service_keys")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceServiceInstancesRequest getValidRequest() throws Exception {
            return ListSpaceServiceInstancesRequest.builder()
                .spaceId("test-space-id")
                .returnUserProvidedServiceInstances(true)
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceServiceInstancesResponse> invoke(ListSpaceServiceInstancesRequest request) {
            return this.spaces.listServiceInstances(request);
        }

    }

    public static final class ListServices extends AbstractClientApiTest<ListSpaceServicesRequest, ListSpaceServicesResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/services?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_services_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceServicesResponse getResponse() {
            return ListSpaceServicesResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(ServiceResource.builder()
                    .metadata(Metadata.builder()
                        .id("fcc4261f-da9a-40ba-9194-6919e0ab87f8")
                        .url("/v2/services/fcc4261f-da9a-40ba-9194-6919e0ab87f8")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(ServiceEntity.builder()
                        .label("label-5")
                        .description("desc-14")
                        .active(true)
                        .bindable(true)
                        .uniqueId("666902ad-81dc-41e9-a351-58e1055e3ab2")
                        .serviceBrokerId("15f1c3a0-910c-4b92-9386-377acada14cb")
                        .planUpdateable(false)
                        .servicePlansUrl("/v2/services/fcc4261f-da9a-40ba-9194-6919e0ab87f8/service_plans")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceServicesRequest getValidRequest() throws Exception {
            return ListSpaceServicesRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceServicesResponse> invoke(ListSpaceServicesRequest request) {
            return this.spaces.listServices(request);
        }

    }

    public static final class ListUserRoles extends AbstractClientApiTest<ListSpaceUserRolesRequest, ListSpaceUserRolesResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(GET).path("/v2/spaces/test-space-id/user_roles?page=-1")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/GET_{id}_user_roles_response.json")
                    .build())
                .build();
        }

        @Override
        protected ListSpaceUserRolesResponse getResponse() {
            return ListSpaceUserRolesResponse.builder()
                .totalResults(1)
                .totalPages(1)
                .resource(UserSpaceRoleResource.builder()
                    .metadata(Metadata.builder()
                        .id("uaa-id-8")
                        .url("/v2/users/uaa-id-8")
                        .createdAt("2015-07-27T22:43:07Z")
                        .build())
                    .entity(UserSpaceRoleEntity.builder()
                        .admin(false)
                        .active(false)
                        .defaultSpaceId(null)
                        .username("everything@example.com")
                        .spaceRole("space_developer")
                        .spaceRole("space_manager")
                        .spaceRole("space_auditor")
                        .spacesUrl("/v2/users/uaa-id-8/spaces")
                        .organizationsUrl("/v2/users/uaa-id-8/organizations")
                        .managedOrganizationsUrl("/v2/users/uaa-id-8/managed_organizations")
                        .billingManagedOrganizationsUrl("/v2/users/uaa-id-8/billing_managed_organizations")
                        .auditedOrganizationsUrl("/v2/users/uaa-id-8/audited_organizations")
                        .managedSpacesUrl("/v2/users/uaa-id-8/managed_spaces")
                        .auditedSpacesUrl("/v2/users/uaa-id-8/audited_spaces")
                        .build())
                    .build())
                .build();
        }

        @Override
        protected ListSpaceUserRolesRequest getValidRequest() throws Exception {
            return ListSpaceUserRolesRequest.builder()
                .spaceId("test-space-id")
                .page(-1)
                .build();
        }

        @Override
        protected Mono<ListSpaceUserRolesResponse> invoke(ListSpaceUserRolesRequest request) {
            return this.spaces.listUserRoles(request);
        }

    }

    public static final class RemoveAuditor extends AbstractClientApiTest<RemoveSpaceAuditorRequest, Void> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/auditors/test-auditor-id")
                    .build())
                .response(TestResponse.builder()
                    .status(NO_CONTENT)
                    .build())
                .build();
        }

        @Override
        protected Void getResponse() {
            return null;
        }

        @Override
        protected RemoveSpaceAuditorRequest getValidRequest() throws Exception {
            return RemoveSpaceAuditorRequest.builder()
                .auditorId("test-auditor-id")
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<Void> invoke(RemoveSpaceAuditorRequest request) {
            return this.spaces.removeAuditor(request);
        }

    }

    public static final class RemoveAuditorByUsername extends AbstractClientApiTest<RemoveSpaceAuditorByUsernameRequest, RemoveSpaceAuditorByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/auditors")
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_auditors_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_auditors_response.json")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceAuditorByUsernameResponse getResponse() {
            return RemoveSpaceAuditorByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("6ee704bb-fc88-40f6-9ab9-02fe8df35730")
                    .url("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730")
                    .createdAt("2016-04-22T19:33:25Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-979")
                    .organizationId("c6aa1f1e-e5b4-4eff-8ae5-3a430866f5ea")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/c6aa1f1e-e5b4-4eff-8ae5-3a430866f5ea")
                    .developersUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/developers")
                    .managersUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/managers")
                    .auditorsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/auditors")
                    .applicationsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/apps")
                    .routesUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/routes")
                    .domainsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/domains")
                    .serviceInstancesUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/service_instances")
                    .applicationEventsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/app_events")
                    .eventsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/events")
                    .securityGroupsUrl("/v2/spaces/6ee704bb-fc88-40f6-9ab9-02fe8df35730/security_groups")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceAuditorByUsernameRequest getValidRequest() throws Exception {
            return RemoveSpaceAuditorByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("auditor@example.com")
                .build();
        }

        @Override
        protected Mono<RemoveSpaceAuditorByUsernameResponse> invoke(RemoveSpaceAuditorByUsernameRequest request) {
            return this.spaces.removeAuditorByUsername(request);
        }

    }

    public static final class RemoveDeveloper extends AbstractClientApiTest<RemoveSpaceDeveloperRequest, Void> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/developers/test-developer-id")
                    .build())
                .response(TestResponse.builder()
                    .status(NO_CONTENT)
                    .build())
                .build();
        }

        @Override
        protected Void getResponse() {
            return null;
        }

        @Override
        protected RemoveSpaceDeveloperRequest getValidRequest() throws Exception {
            return RemoveSpaceDeveloperRequest.builder()
                .developerId("test-developer-id")
                .spaceId("test-space-id")
                .build();
        }

        @Override
        protected Mono<Void> invoke(RemoveSpaceDeveloperRequest request) {
            return this.spaces.removeDeveloper(request);
        }
    }

    public static final class RemoveDeveloperByUsername extends AbstractClientApiTest<RemoveSpaceDeveloperByUsernameRequest, RemoveSpaceDeveloperByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/developers")
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_developers_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_developers_response.json")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceDeveloperByUsernameResponse getResponse() {
            return RemoveSpaceDeveloperByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("998375df-21ec-4d73-a0fd-83c11b7c7c1d")
                    .url("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d")
                    .createdAt("2016-04-22T19:33:26Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-1016")
                    .organizationId("d2ba20ee-07f8-4bab-91c7-41a5e103ca57")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/d2ba20ee-07f8-4bab-91c7-41a5e103ca57")
                    .developersUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/developers")
                    .managersUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/managers")
                    .auditorsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/auditors")
                    .applicationsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/apps")
                    .routesUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/routes")
                    .domainsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/domains")
                    .serviceInstancesUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/service_instances")
                    .applicationEventsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/app_events")
                    .eventsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/events")
                    .securityGroupsUrl("/v2/spaces/998375df-21ec-4d73-a0fd-83c11b7c7c1d/security_groups")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceDeveloperByUsernameRequest getValidRequest() throws Exception {
            return RemoveSpaceDeveloperByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("developer@example.com")
                .build();
        }

        @Override
        protected Mono<RemoveSpaceDeveloperByUsernameResponse> invoke(RemoveSpaceDeveloperByUsernameRequest request) {
            return this.spaces.removeDeveloperByUsername(request);
        }

    }

    public static final class RemoveManager extends AbstractClientApiTest<RemoveSpaceManagerRequest, Void> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/managers/test-manager-id")
                    .build())
                .response(TestResponse.builder()
                    .status(NO_CONTENT)
                    .build())
                .build();
        }

        @Override
        protected Void getResponse() {
            return null;
        }

        @Override
        protected RemoveSpaceManagerRequest getValidRequest() throws Exception {
            return RemoveSpaceManagerRequest.builder()
                .spaceId("test-space-id")
                .managerId("test-manager-id")
                .build();
        }

        @Override
        protected Mono<Void> invoke(RemoveSpaceManagerRequest request) {
            return this.spaces.removeManager(request);
        }

    }

    public static final class RemoveManagerByUsername extends AbstractClientApiTest<RemoveSpaceManagerByUsernameRequest, RemoveSpaceManagerByUsernameResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/managers")
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_managers_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/DELETE_{id}_managers_response.json")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceManagerByUsernameResponse getResponse() {
            return RemoveSpaceManagerByUsernameResponse.builder()
                .metadata(Metadata.builder()
                    .id("9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2")
                    .url("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2")
                    .createdAt("2016-04-22T19:33:27Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("name-1041")
                    .organizationId("2e1dbf6f-426e-4ad7-b48e-347bbd2bdaa6")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/2e1dbf6f-426e-4ad7-b48e-347bbd2bdaa6")
                    .developersUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/developers")
                    .managersUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/managers")
                    .auditorsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/auditors")
                    .applicationsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/apps")
                    .routesUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/routes")
                    .domainsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/domains")
                    .serviceInstancesUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/service_instances")
                    .applicationEventsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/app_events")
                    .eventsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/events")
                    .securityGroupsUrl("/v2/spaces/9f29c6d5-10cf-4d2c-a934-b0f2ea054bd2/security_groups")
                    .build())
                .build();
        }

        @Override
        protected RemoveSpaceManagerByUsernameRequest getValidRequest() throws Exception {
            return RemoveSpaceManagerByUsernameRequest.builder()
                .spaceId("test-space-id")
                .username("manager@example.com")
                .build();
        }

        @Override
        protected Mono<RemoveSpaceManagerByUsernameResponse> invoke(RemoveSpaceManagerByUsernameRequest request) {
            return this.spaces.removeManagerByUsername(request);
        }

    }

    public static final class RemoveSecurityGroup extends AbstractClientApiTest<RemoveSpaceSecurityGroupRequest, Void> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(DELETE).path("/v2/spaces/test-space-id/security_groups/test-security-group-id")
                    .build())
                .response(TestResponse.builder()
                    .status(NO_CONTENT)
                    .build())
                .build();
        }

        @Override
        protected Void getResponse() {
            return null;
        }

        @Override
        protected RemoveSpaceSecurityGroupRequest getValidRequest() throws Exception {
            return RemoveSpaceSecurityGroupRequest.builder()
                .spaceId("test-space-id")
                .securityGroupId("test-security-group-id")
                .build();
        }

        @Override
        protected Mono<Void> invoke(RemoveSpaceSecurityGroupRequest request) {
            return this.spaces.removeSecurityGroup(request);
        }

    }

    public static final class Update extends AbstractClientApiTest<UpdateSpaceRequest, UpdateSpaceResponse> {

        private final ReactorSpaces spaces = new ReactorSpaces(AUTHORIZATION_PROVIDER, HTTP_CLIENT, OBJECT_MAPPER, this.root);

        @Override
        protected InteractionContext getInteractionContext() {
            return InteractionContext.builder()
                .request(TestRequest.builder()
                    .method(PUT).path("/v2/spaces/test-space-id")
                    .payload("fixtures/client/v2/spaces/PUT_{id}_request.json")
                    .build())
                .response(TestResponse.builder()
                    .status(OK)
                    .payload("fixtures/client/v2/spaces/PUT_{id}_response.json")
                    .build())
                .build();
        }

        @Override
        protected UpdateSpaceResponse getResponse() {
            return UpdateSpaceResponse.builder()
                .metadata(Metadata.builder()
                    .id("e7b9e252-88cb-415c-ace4-2864922e550c")
                    .url("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c")
                    .createdAt("2015-07-27T22:43:08Z")
                    .updatedAt("2015-07-27T22:43:08Z")
                    .build())
                .entity(SpaceEntity.builder()
                    .name("New Space Name")
                    .organizationId("71c72756-e8b8-4c4a-b832-b3f9e3052c70")
                    .allowSsh(true)
                    .organizationUrl("/v2/organizations/71c72756-e8b8-4c4a-b832-b3f9e3052c70")
                    .developersUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/developers")
                    .managersUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/managers")
                    .auditorsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/auditors")
                    .applicationsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/apps")
                    .routesUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/routes")
                    .domainsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/domains")
                    .serviceInstancesUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/service_instances")
                    .applicationEventsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/app_events")
                    .eventsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/events")
                    .securityGroupsUrl("/v2/spaces/e7b9e252-88cb-415c-ace4-2864922e550c/security_groups")
                    .build())
                .build();
        }

        @Override
        protected UpdateSpaceRequest getValidRequest() throws Exception {
            return UpdateSpaceRequest.builder()
                .spaceId("test-space-id")
                .name("New Space Name")
                .build();
        }

        @Override
        protected Mono<UpdateSpaceResponse> invoke(UpdateSpaceRequest request) {
            return this.spaces.update(request);
        }

    }

}
