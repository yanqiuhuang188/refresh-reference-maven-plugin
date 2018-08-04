# refresh-reference-maven-plugin

# target project
<plugins>
	<!-- clear local nimble-common dependency -->
	<plugin>
		<groupId>com.nimble</groupId>
		<artifactId>refresh-reference-maven-plugin</artifactId>
		<version>1.0-SNAPSHOT</version>
		<!--<executions>
                <execution>
                    <id>attach-source</id>
                    <goals>
                        <goal></goal>
                    </goals>
                </execution>
            </executions>-->
		<configuration>
			<paths>
				<path>${settings.localRepository}\com\nimble\nimble-common</path>
			</paths>
		</configuration>
	</plugin>
</plugins>
