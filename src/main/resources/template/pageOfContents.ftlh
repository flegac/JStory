		  <#assign x = 0>
		  <nav id="page-of-content" class="navbar navbar-light bg-light sticky-top float-right flex-column" >
			<#list page.chapters as chapter>
	 			<a class="nav-link" style="margin-left: 0cm" href="#chapter-${chapter?counter}">Chapter ${chapter?counter}</a>
				<#list chapter.sections as section>
					<a class="nav-link" style="margin-left: 1cm" href="#section-${chapter?counter}-${section?counter}">Section ${chapter?counter}.${section?counter}</a>
					<#list section.epics as story>
						<#assign x++ >
			 			<a class="nav-link" style="margin-left: 1.5cm" href="#story-${x}">Story ${x}</a>
					</#list>
					<#list section.stories as story>
						<#assign x++ >
			  			<a class="nav-link" style="margin-left: 1.5cm" href="#story-${x}">Story ${x}</a>
					</#list>
				</#list>
			</#list>

			<#list page.tests as test>
				<a class="nav-link" style="margin-left: .5cm" href="#test-${test?counter}">Test ${test?counter}</a>
			</#list>
			
		  </nav>