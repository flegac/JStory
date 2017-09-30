
		  <nav id="table-of-contents" class="navbar navbar-light bg-light sticky-top float-left flex-column" >
			<h3>Table of contents</h3>

			<div class="btn-group" data-toggle="buttons">
			  <label class="btn btn-primary">
			    <input type="checkbox" onchange="$('.story').toggle();return false;"> story
			  </label>
			  <label class="btn btn-primary">
			    <input type="checkbox" onchange="$('.scenario').toggle();return false;"> test
			  </label>
			</div>

		  	<#assign x = 0>
			<#list page.chapters as chapter>
				<div class="chapter">
		 			<a class="nav-link" href="#chapter-${chapter?counter}">${chapter?counter}. ${chapter.title?capitalize}</a>
					<#list chapter.sections as section>
						<div class="section">
							<a class="nav-link" href="#section-${chapter?counter}-${section?counter}">${chapter?counter}.${section?counter}. ${section.title?capitalize}</a>
							<#list section.subSections as subSection>
								<div class="subsection" href="#subsection-${chapter?counter}-${section?counter}-${subSection?counter}">
									<a class="nav-link" href="#subsection-${chapter?counter}-${section?counter}-${subSection?counter}">${chapter?counter}.${section?counter}.${subSection?counter}. ${subSection.title?capitalize}</a>
									<#list subSection.epics as story>
										<#assign x++ >
							 			<a class="story nav-link" href="#story-${x}">Story ${x}</a>
										<#list story.tests as test>
								  			<a class="scenario nav-link" href="#scenario-${x}">Test ${x}</a>
										</#list>							 			
									</#list>
									<#list subSection.stories as story>
										<#assign x++ >
							  			<a class="story nav-link" href="#story-${x}">Story ${x}</a>
										<#list story.tests as test>
								  			<a class="scenario nav-link" href="#scenario-${x}">Test ${x}</a>
										</#list>							  			
									</#list>
								</div>
							</#list>
						</div>
					</#list>
				</div>
			</#list>
		  </nav>