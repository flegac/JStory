		<h1>Cahier de tests</h1>
		<#list page.tests as test>
			<div class="scenario" id="test-${test?counter}">
				<b>${test.title?capitalize}</b>
				<ol>
				<#list test.steps as step>
					<li>${step}</li>
				</#list>
				</ol>
			</div>
		</#list>
