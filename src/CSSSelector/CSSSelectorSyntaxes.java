package CSSSelector;

public class CSSSelectorSyntaxes 
{
	/**
	 * 
	Id:
	TagName#Id Or #Id
	
	ClassName:
	TagName.ClassName Or .ClassName
	TagName.AttributeValue.AttributeValue.AttributeValue
	
	TagName[id = 'Value'] --> CSSSelector with 1 Attribute.
	TagName[id = 'Value'] [type = 'Value'] --> CSSSelector with 2 Attributes.
	
	Contains:
	TagName[id* = 'Test_']
	
	StartsWith:
	TagName[id^ = 'Pavan']
	
	EndsWith:
	TagName[id$ = 'Kumar']
	
	Comma:
	TagName.Value,TagName#Value
	
	Traversing:
	First-Of-Type : It will give First Matching Element among All.
	ul#categories>li:first-of-type
	
	Last-Of-Type : It will give Last Matching Element among All.
	ul#categories>li:last-of-type
	
	Nth of Type : To Select Specific Element among All.
	ul#categories>li:nth-of-type(1)
	ul#categories>li:nth-of-type(3)
	ul#categories>li:nth-of-type(5)
	
	To Fetch all Elements coming under a Single Tag:
	ul#categories>li:nth-of-type(n)
	
	Sibling of Element:
	div.private-form_input-wrapper + div.private-form_meta
	*
	**/
}
