using System.ComponentModel.DataAnnotations;

namespace ToDo.Web.Mvc.ViewModels
{
    public class NewTaskViewModel
    {
        [Required]
        [Display(Name = "New Task:")]
        public string Description { get; set; }
    }
}