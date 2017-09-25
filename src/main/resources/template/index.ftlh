<#ftl output_format="HTML" />
<html>
	<head>
		<title>${page.title}</title>
		<link rel="stylesheet" type="text/css" href="style/style.css" />
	</head>

	<body>
		<h1>${page.title}</h1>
		<#list page.chapters as chapter>
			<h2>Chapter ${chapter?index+1} ${chapter.title}</h2>
			<#list chapter.sections as section>
				<h3>Section ${chapter?index+1}.${section?index+1} ${section.title}</h3>
				<#list section.stories as story>
					<#include "story.ftlh" />
				</#list>
			</#list>
		</#list>

		<h1>Cahier de tests</h1>
		<#list page.tests as test>
			<#include "test.ftlh" />
		</#list>

	</body>
</html>
