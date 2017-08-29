using System.ComponentModel.DataAnnotations;

namespace DemoApp.ViewModels
{
    public class NewTaskViewModel
    {
        [Required]
        [Display(Name = "New Task:")]
        public string Description { get; set; }
    }
}