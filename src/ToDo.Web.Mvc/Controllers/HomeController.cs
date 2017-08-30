using System;
using System.Threading.Tasks;
using System.Web.Mvc;
using ToDo.Web.Mvc.Models;
using ToDo.Web.Mvc.ViewModels;

namespace ToDo.Web.Mvc.Controllers
{
    public class HomeController : Controller
    {
        private readonly ITasksRepository _repository = new TasksRepository();

        [HttpGet]
        public async Task<ActionResult> Index()
        {
            var allTasks = await _repository.ListAsync();

            var model = new IndexViewModel()
            {
                AllTasks = allTasks,
                NewTask = new NewTaskViewModel()
            };

            return View(model);
        }

        [HttpPost]
        public async Task<ActionResult> Index(IndexViewModel model)
        {
            if (!ModelState.IsValid)
            {
                return View(model);
            }

            await _repository.AddAsync(new TaskItem()
            {
                Description = model.NewTask.Description,
                DateCreated = DateTime.Now,
                IsCompleted = false
            });
            return RedirectToAction("Index");
        }
    }
}