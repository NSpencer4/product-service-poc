package com.productservicepoc.providers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {
    // To be used by the GraphQL Java Spring Adapter to make the schema available at /graphql
    private GraphQL graphQL;

    @PostConstruct
    public void init() throws IOException {
        // Read the schema in via resources
        URL url = Resources.getResource("schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        // Pass the executable schema and create the graphql instance
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    /**
     * Used to build out a GraphQL executable schema
     * @param sdl - GraphQL schema url
     * @return GraphQLSchema - instance of the GraphQL schema
     */
    private GraphQLSchema buildSchema(String sdl) {
        // Parse the passed in schema to define types
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        // Build the schema
        RuntimeWiring runtimeWiring = buildWiring();
        // Prep the schema generator
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        // Create the executable GraphQL schema
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    /**
     * Helper method to create the runtime wiring and expose query options.
     * @return RuntimeWiring - GraphQL runtime wiring
     */
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")).build();
    }

    @Bean
    public GraphQL getGraphQLInstance() {
        return graphQL;
    }
}
