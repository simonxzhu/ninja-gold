package com.simon.ninjagold;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class NinjagoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjagoldApplication.class, args);
	}
	
	@Controller
	class GameController {
		@RequestMapping("") 
		String index(HttpSession session, Model model) {
			Game game = (Game) session.getAttribute("ninjaGame");
			if (game == null) {
				game = new Game();
				session.setAttribute("ninjaGame", game);
			}
			model.addAttribute("game", game);
			return "index.jsp";
		}
		
		@RequestMapping(value="process", method=RequestMethod.POST)
		String process(@RequestParam(value="location") String location, HttpSession session) {
			Game game = (Game) session.getAttribute("ninjaGame");
			if (game != null) {
				if (game.play(location)) {
					return "redirect:/prison";
				}
			}
			return "redirect:/";
		}
		
		@RequestMapping("reset") 
		String reset(HttpSession session) {
			session.removeAttribute("ninjaGame");
			return "redirect:/";
		}
		
		@RequestMapping("prison") 
		String prison() {
			return "prison.jsp";
		}
	}

}
